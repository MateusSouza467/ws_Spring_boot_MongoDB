package com.mateussouza.ws_mongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateussouza.ws_mongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1","Maria Souza","maria@gmail.com");
		User mateus = new User("1","Mateus Souza","mateus@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,mateus));
		return ResponseEntity.ok().body(list);
	}
}
