package com.asm1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm1.model.Publisher;
import com.asm1.repository.PublisherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepo;

	public Flux<Publisher> getAll() {
		return publisherRepo.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<Publisher> getById(final String id) {
		return publisherRepo.findById(id);
	}

	public Mono<Publisher> update(final String id, final Publisher publisher) {
		return publisherRepo.save(publisher);
	}

	public Mono<Publisher> save(final Publisher publisher) {
		return publisherRepo.save(publisher);
	}

	public Mono<Void> delete(final String id) {
		return publisherRepo.deleteById(id);
	}
}
