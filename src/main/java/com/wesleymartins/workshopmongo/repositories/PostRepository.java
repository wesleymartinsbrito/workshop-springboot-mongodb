package com.wesleymartins.workshopmongo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wesleymartins.workshopmongo.domain.Post;
import com.wesleymartins.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	User save(Optional<User> newObj);
	
	@Query("{ 'title': {$regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
		
}
