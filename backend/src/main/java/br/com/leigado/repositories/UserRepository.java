package br.com.leigado.repositories;

import javax.enterprise.context.ApplicationScoped;

import br.com.leigado.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
