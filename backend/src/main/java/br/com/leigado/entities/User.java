package br.com.leigado.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.leigado.entities.data.Email;
import br.com.leigado.entities.data.Name;
import br.com.leigado.entities.data.Password;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private Name name;
	@Embedded
	private Email email;
	@Embedded
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

	public Long getId() {
		return id;
	}
	
}
