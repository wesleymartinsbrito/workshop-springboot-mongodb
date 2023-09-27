package com.wesleymartins.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleymartins.workshopmongo.domain.User;
import com.wesleymartins.workshopmongo.dto.UserDTO;
import com.wesleymartins.workshopmongo.repositories.UserRepository;
import com.wesleymartins.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public Optional<User> findById(String id) {
		Optional<User> user = repo.findById(id);
		return Optional.ofNullable(user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")));
	}
	
	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public void delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
