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

import com.asm1.model.Member;
import com.asm1.service.MemberService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("member")
@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping
	public Flux<Member> getAll() {
		System.out.println("All member information");
		return memberService.getAll();
	}

	@GetMapping("{id}")
	public Mono<Member> getById(@PathVariable("id") final String id) {
		System.out.println("One member information for the given ID: " + id);
		return memberService.getById(id);
	}

	@PutMapping("{id}")
	public Mono<Member> updateById(@PathVariable("id") final String id, @RequestBody final Member member) {
		System.out.println("Updating member Info: " + id);
		return memberService.update(id, member);
	}

	@PostMapping
	public Mono<Member> save(@RequestBody final Member member) {
		System.out.println("Added member Info: " + member.getMembId() + " - " + member.getName()
				+ " - " + member.getAddress() + " - " + member.getMembType()
				+ " - " + member.getMembDate() + " - " + member.getExpiryDate());
		return memberService.save(member);
	}

	@DeleteMapping("{id}")
	public Mono<Void> deleteById(@PathVariable("id") final String id) {
		System.out.println("Deleting member: " + id);
		return memberService.delete(id);
	}
}
