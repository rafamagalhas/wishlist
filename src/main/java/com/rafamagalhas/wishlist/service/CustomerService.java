package com.rafamagalhas.wishlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rafamagalhas.wishlist.exception.EntityAlreadyExistsException;
import com.rafamagalhas.wishlist.exception.ResourceNotFoundException;
import com.rafamagalhas.wishlist.model.Customer;
import com.rafamagalhas.wishlist.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer create(Customer customer) throws EntityAlreadyExistsException {
		this.findByEmail(customer.getEmail()).orElseThrow(() -> new EntityAlreadyExistsException(""));
		return this.customerRepository.save(customer);
	}
	
	public Optional<Customer> findById(Long id) {
		return this.customerRepository.findById(id);
	}
	
	public List<Customer> getAll() {
		return new ArrayList<>(customerRepository.findAll());
	}
	
	public Customer update(Customer newCustomer, Long id) throws ResourceNotFoundException {
		Optional<Customer> optionalCustomer = this.findById(id);
		Customer customer = optionalCustomer.orElseThrow(() -> new ResourceNotFoundException(""));
		customer.setName(newCustomer.getName());
		customer.setEmail(newCustomer.getEmail());
		return customer;
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
		Optional<Customer> optionalCustomer = this.findById(id);
		Customer customer = optionalCustomer.orElseThrow(() -> new ResourceNotFoundException(""));
		this.customerRepository.delete(customer);
	}
	
	
	public Optional<Customer> findByEmail(String email) {
		return this.customerRepository.findByEmail(email);
	}

}
