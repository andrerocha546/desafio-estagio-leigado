package br.com.leigado.entities.data;

import java.util.StringJoiner;
import java.util.regex.Pattern;

import br.com.leigado.entities.data.exception.DataException;

public class ValidatorName implements Validator {
	
	private static final String UPPERCASE = "(?:[\\p{Lu}&&[\\p{IsLatin}]])";
	private static final String LOWERCASE = "(?:[\\p{Ll}&&[\\p{IsLatin}]])";

	private static final String PREFIX = choice("d'", "D'", "O'", "Mc", "Mac", "al\\-");
	private static final String SUFFIX = choice("Jr\\.", "II", "III", "IV");
	private static final String CONJUNCTION = choice("e", "y", "de" + opt(choice(" la", " las", " lo", " los")), "do",
			"dos", "da", "das", "del", "van", "von", "bin", "le");
	private static final String NAME = UPPERCASE + plus(opt("'") + LOWERCASE);
	private static final String PRENAME = NAME + star("\\-" + NAME);
	private static final String LASTNAME = choice(opt(PREFIX) + NAME, PRENAME);
	private static final String FULL_NAME = "^" + PRENAME + plus(" " + opt(CONJUNCTION + " ") + LASTNAME)
			+ opt(" " + SUFFIX) + "$";

	private static String opt(String in) {
		return "(?:" + in + ")?";
	}

	private static String plus(String in) {
		return "(?:" + in + ")+";
	}

	private static String star(String in) {
		return "(?:" + in + ")*";
	}

	private static String choice(String... in) {
		StringJoiner sj = new StringJoiner("|", "(?:", ")");
		for (String s : in) {
			sj.add(s);
		}
		return sj.toString();
	}

	private static final Pattern REGEX_NAME = Pattern.compile(FULL_NAME);
	
	@Override
	public boolean isValid(String name) {
		try {			
			boolean isValid = REGEX_NAME.matcher(name).matches();
			return isValid;
		} catch (NullPointerException e) {
			throw new DataException("O nome não pode ser vazio.");
		}
    }

}
