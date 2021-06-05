package br.com.leigado.builder;

import br.com.leigado.entities.User;

public interface Builder {
	
	Builder reset();
	Builder setName(String name);
	Builder setEmail(String email);
	Builder setPassword(String password);
	User getResult();

}
