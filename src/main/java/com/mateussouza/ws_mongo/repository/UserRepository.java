package com.mateussouza.ws_mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mateussouza.ws_mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User save(Optional<User> newObj);



}
