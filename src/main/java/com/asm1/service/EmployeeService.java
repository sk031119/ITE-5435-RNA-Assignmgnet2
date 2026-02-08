package com.asm1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm1.model.Employee;
import com.asm1.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public Flux<Employee> getAll() {

        return empRepo.findAll().switchIfEmpty(Flux.empty());

  }
	
	public Mono<Employee> getById(final String id) {

        return empRepo.findById(id);

  }	
	
	
	public Mono update(final String id, final Employee employee) {

        return empRepo.save(employee);

  }
	
	public Mono save(final Employee employee) {

        return empRepo.save(employee);

  }


}
