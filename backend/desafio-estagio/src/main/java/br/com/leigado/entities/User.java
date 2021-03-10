package br.com.leigado.entities;

import br.com.leigado.entities.data.Email;
import br.com.leigado.entities.data.Name;
import br.com.leigado.entities.data.Password;

public class User {

	private Integer id;
	private Name name;
	private Email email;
	private Password password;
	
	public User() {
	}

	public User(Name name, Email email, Password password) {
		this.id = null;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}
	
}
