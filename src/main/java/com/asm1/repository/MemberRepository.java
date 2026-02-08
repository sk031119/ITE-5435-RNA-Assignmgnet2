package com.asm1.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.asm1.model.Member;


@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

}
