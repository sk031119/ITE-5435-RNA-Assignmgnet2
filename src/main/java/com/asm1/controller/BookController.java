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

import com.asm1.model.Book;
import com.asm1.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("book")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public Flux<Book> getAll() {
		System.out.println("All book information");
		return bookService.getAll();
	}

	@GetMapping("{id}")
	public Mono<Book> getById(@PathVariable("id") final String id) {
		System.out.println("One book information for the given ID: " + id);
		return bookService.getById(id);
	}

	@PutMapping("{id}")
	public Mono<Book> updateById(@PathVariable("id") final String id, @RequestBody final Book book) {
		System.out.println("Updating book Info: " + id);
		return bookService.update(id, book);
	}

	@PostMapping
	public Mono<Book> save(@RequestBody final Book book) {
		System.out.println("Added book Info: " + book.getBookId() + " - " + book.getTitle()
				+ " - " + book.getAuthor() + " - " + book.getPrice() + " - " + book.isAvailable());
		return bookService.save(book);
	}

	@DeleteMapping("{id}")
	public Mono<Void> deleteById(@PathVariable("id") final String id) {
		System.out.println("Deleting book: " + id);
		return bookService.delete(id);
	}
}
