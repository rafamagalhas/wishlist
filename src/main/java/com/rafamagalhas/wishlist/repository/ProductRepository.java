package com.rafamagalhas.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafamagalhas.wishlist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
