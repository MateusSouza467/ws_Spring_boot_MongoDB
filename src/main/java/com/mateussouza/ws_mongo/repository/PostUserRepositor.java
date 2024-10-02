package com.mateussouza.ws_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mateussouza.ws_mongo.domain.Post;

@Repository
public interface PostUserRepositor extends MongoRepository<Post, String> {




}
