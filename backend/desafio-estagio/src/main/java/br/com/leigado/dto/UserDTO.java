package br.com.leigado.dto;

import java.io.Serializable;

import br.com.leigado.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;

	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName().getName();
		this.email = user.getEmail().getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
