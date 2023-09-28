package com.wesleymartins.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleymartins.workshopmongo.domain.Post;
import com.wesleymartins.workshopmongo.repositories.PostRepository;
import com.wesleymartins.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Optional<Post> findById(String id) {
		Optional<Post> user = Optional.of(repo.findById(id).get());
		return Optional.ofNullable(user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")));
	}
}
