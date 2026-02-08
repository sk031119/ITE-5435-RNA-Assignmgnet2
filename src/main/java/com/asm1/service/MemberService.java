package com.asm1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm1.model.Member;
import com.asm1.repository.MemberRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;

	public Flux<Member> getAll() {
		return memberRepo.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<Member> getById(final String id) {
		return memberRepo.findById(id);
	}

	public Mono<Member> update(final String id, final Member member) {
		return memberRepo.save(member);
	}

	public Mono<Member> save(final Member member) {
		return memberRepo.save(member);
	}

	public Mono<Void> delete(final String id) {
		return memberRepo.deleteById(id);
	}
}
