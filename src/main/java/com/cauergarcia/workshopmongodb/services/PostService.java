package com.cauergarcia.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cauergarcia.workshopmongodb.domain.Post;
import com.cauergarcia.workshopmongodb.repositories.PostRepository;
import com.cauergarcia.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> user = postRepository.findById(id);
		if(!user.isPresent()) {
			throw new ObjectNotFoundException("Object not found!");
		}
		return user.get();
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
}
