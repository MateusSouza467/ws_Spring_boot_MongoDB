package com.mateussouza.ws_mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateussouza.ws_mongo.domain.Post;
import com.mateussouza.ws_mongo.repository.PostUserRepositor;
import com.mateussouza.ws_mongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostUserRepositor repo;
	
	
	public Post findById(String id) {
		return repo.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"+ id));	
	}
	
}