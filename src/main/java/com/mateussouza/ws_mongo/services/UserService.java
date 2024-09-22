package com.mateussouza.ws_mongo.services;

import java.util.List;
import java.util.Optional;

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
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
	    Optional<User> optionalObj = repo.findById(obj.getId());
	    
	    User newObj = optionalObj.get();
	    updateData(newObj, obj);
	    return repo.save(newObj);
	}

	
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
	
}
