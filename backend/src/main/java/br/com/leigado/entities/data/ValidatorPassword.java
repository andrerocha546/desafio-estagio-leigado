package br.com.leigado.entities.data;

import br.com.leigado.entities.data.exception.DataException;

public class ValidatorPassword implements Validator {

	@Override
	public boolean isValid(String string) {
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
		try {
			boolean isValid = string.matches(pattern);			
			return isValid;
		} catch (NullPointerException e) {
			throw new DataException("Senha invalida. Digite outra.");
		}
	}

}
