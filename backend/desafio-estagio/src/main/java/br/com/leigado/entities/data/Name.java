package br.com.leigado.entities.data;

import javax.persistence.Embeddable;

import br.com.leigado.entities.data.exception.DataException;

@Embeddable
public class Name {
	
	private static final Validator VALIDATOR = new ValidatorName();
	
	private String name;

	public Name(String name) {
		this.name = isValidName(name);
	}

	public Name() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = isValidName(name);
	}
	
	private String isValidName(String name) {
		if (!VALIDATOR.isValid(name) || name == null) {
			throw new DataException("Nome " + name + "invalido");
		}
		return name;
	}

}
