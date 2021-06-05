package br.com.leigado.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.leigado.dto.UserDTO;
import br.com.leigado.entities.User;
import br.com.leigado.repositories.UserRepository;

@Path("/users")
public class UserResource {
	
	@Inject
	private UserRepository repository;
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(User user) {
		repository.persist(Arrays.asList(user));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> findAll() {
		List<User> users = repository.listAll();
		List<UserDTO> usersDto = users.stream()
				.map(user -> new UserDTO(user)).collect(Collectors.toList());
		return usersDto;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO findById(@PathParam Long id) {
		User user = repository.findById(id);
		return new UserDTO(user);
	}
 	
	@DELETE
	@Transactional
	@Path("/{id}")
	public void deleteById(@PathParam Long id) {
		User user = repository.findById(id);
		repository.delete(user);
	}
	
	@PUT
	@Transactional
	@Path("/{id}")
	public void updateById(@PathParam Long id, User newUser) {
		User user = repository.findById(id);
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
		repository.persist(user);
	}
	

}
