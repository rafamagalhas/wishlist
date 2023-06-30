package com.rafamagalhas.wishlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafamagalhas.wishlist.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long>{
	Optional<Wishlist> findByCustomerId(Long customerId);
}
