package com.mateussouza.ws_mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mateussouza.ws_mongo.domain.Post;
import com.mateussouza.ws_mongo.domain.User;
import com.mateussouza.ws_mongo.dto.AuthorDTO;
import com.mateussouza.ws_mongo.dto.CommentDTO;
import com.mateussouza.ws_mongo.repository.PostUserRepositor;
import com.mateussouza.ws_mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostUserRepositor postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null,"Maria Brown","maria@gmail.com");
		User alex = new User(null,"Alex Green","alex@gmail.com");
		User bob = new User(null,"Bob Grey","bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "vou viajar para são paulo", new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"bom dia","Acordei cansado", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa jornada!",sdf.parse("21/03/2018"),new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Seja feliz",sdf.parse("22/03/2018"),new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Bom diaaaaaaaaa",sdf.parse("23/03/2018"),new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
	}

}
