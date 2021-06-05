package br.com.leigado.builder;

import br.com.leigado.entities.User;
import br.com.leigado.entities.data.Email;
import br.com.leigado.entities.data.Name;
import br.com.leigado.entities.data.Password;

public class UserBuilder implements Builder {

	private User user = new User();
	
	@Override
	public Builder reset() {
		this.user = new User();
		return this;
	}

	@Override
	public Builder setName(String name) {
		Name userName = new Name(name);
		this.user.setName(userName);
		return this;
	}

	@Override
	public Builder setEmail(String email) {
		Email userEmail = new Email(email);
		this.user.setEmail(userEmail);
		return this;
	}

	@Override
	public Builder setPassword(String password) {
		Password userPass = new Password(password);
		this.user.setPassword(userPass);
		return this;
	}

	@Override
	public User getResult() {
		return this.user;
	}
	
	

}
