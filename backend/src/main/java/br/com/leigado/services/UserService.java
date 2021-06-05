package br.com.leigado.services;

import javax.inject.Inject;

import br.com.leigado.entities.User;
import br.com.leigado.repositories.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

public class UserService {
	
	@Inject
	private UserRepository repository;
	
	public PanacheQuery<User> findAll() {
		return repository.findAll();
	}
	
	public void deleteById(User user) {
		repository.delete(user);
	}

}
