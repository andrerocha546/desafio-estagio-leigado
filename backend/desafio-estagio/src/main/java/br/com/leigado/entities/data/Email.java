package br.com.leigado.entities.data;

import javax.persistence.Embeddable;

import br.com.leigado.entities.data.exception.DataException;

@Embeddable
public class Email {
	
	private static final Validator VALIDATOR = new ValidatorEmail();
	
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
