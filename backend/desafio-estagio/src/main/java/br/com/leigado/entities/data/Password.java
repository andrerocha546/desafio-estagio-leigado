package br.com.leigado.entities.data;

import br.com.leigado.entities.data.exception.DataException;
import br.com.leigado.services.BCryptHashService;
import br.com.leigado.services.Encryptor;

public class Password {
	
	private static final Validator VALIDATOR = new ValidatorPassword();
	private static final Encryptor ENCRYPTOR = new BCryptHashService();

	private String password;

	public Password() {
	}

	public Password(String password) {
		this.password = encryptPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = encryptPassword(password);
	}

	private String isValidPassword(String password) {
		if (!VALIDATOR.isValid(password) || password == null) {
			throw new DataException("Senha invalida, digite uma melhor.");
		}
		return password;
	}
	
	private String encryptPassword(String password) {
		String passwdEncrypt = ENCRYPTOR.encrypt(isValidPassword(password));
		return passwdEncrypt;
	}

}
