package com.asm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asm1.model.Publisher;
import com.asm1.service.PublisherService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("publisher")
@RestController
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@GetMapping
	public Flux<Publisher> getAll() {
		System.out.println("All publisher information");
		return publisherService.getAll();
	}

	@GetMapping("{id}")
	public Mono<Publisher> getById(@PathVariable("id") final String id) {
		System.out.println("One publisher information for the given ID: " + id);
		return publisherService.getById(id);
	}

	@PutMapping("{id}")
	public Mono<Publisher> updateById(@PathVariable("id") final String id, @RequestBody final Publisher publisher) {
		System.out.println("Updating publisher Info: " + id);
		return publisherService.update(id, publisher);
	}

	@PostMapping
	public Mono<Publisher> save(@RequestBody final Publisher publisher) {
		System.out.println("Added publisher Info: " + publisher.getPubId() + " - " + publisher.getName()
				+ " - " + publisher.getAddress());
		return publisherService.save(publisher);
	}

	@DeleteMapping("{id}")
	public Mono<Void> deleteById(@PathVariable("id") final String id) {
		System.out.println("Deleting publisher: " + id);
		return publisherService.delete(id);
	}
}
