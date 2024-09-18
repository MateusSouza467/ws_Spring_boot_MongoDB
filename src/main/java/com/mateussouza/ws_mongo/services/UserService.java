package com.mateussouza.ws_mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateussouza.ws_mongo.domain.User;
import com.mateussouza.ws_mongo.dto.UserDTO;
import com.mateussouza.ws_mongo.repository.UserRepository;
import com.mateussouza.ws_mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	 
	public User findById(String id) {
		return repo.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"+ id));	
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
	
}
