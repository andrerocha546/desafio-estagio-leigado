package br.com.leigado.services;

import io.quarkus.elytron.security.common.BcryptUtil;

public class BCryptHashService implements Encryptor {

	@Override
	public String encrypt(String password) {
		return BcryptUtil.bcryptHash(password);
	}

//	@Override
//	public boolean checkPassword(String decryptCode, String hashed) {
//		BcryptUtil.
//		return false;
//	}

}
