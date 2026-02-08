package com.asm1.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.asm1.model.Publisher;


@Repository
public interface PublisherRepository extends ReactiveMongoRepository<Publisher, String> {

}
