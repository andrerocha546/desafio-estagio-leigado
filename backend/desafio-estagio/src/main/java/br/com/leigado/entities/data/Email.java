package br.com.leigado.entities.data;

import br.com.leigado.entities.data.exception.DataException;

public class Email {
	
	private static final Validator VALIDATOR = new EmailValidator();
	
	private String email;
	
	public Email() {
	}

	public Email(String email) {
		this.email = isValidEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email =  isValidEmail(email);
	}
	
	private String isValidEmail(String email) {
		if (!VALIDATOR.isValid(email) || email == null) {
			throw new DataException("Email " + email + " não é valido");
		}
		return email;
	}

}
