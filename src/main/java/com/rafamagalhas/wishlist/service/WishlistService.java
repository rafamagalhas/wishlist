package com.rafamagalhas.wishlist.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.rafamagalhas.wishlist.exception.ResourceNotFoundException;
import com.rafamagalhas.wishlist.model.Product;
import com.rafamagalhas.wishlist.model.Wishlist;
import com.rafamagalhas.wishlist.repository.WishlistRepository;

@Service
public class WishlistService {
	 private final WishlistRepository wishlistRepository;

	    public WishlistService(WishlistRepository wishlistRepository) {
	        this.wishlistRepository = wishlistRepository;
	    }
	    public Wishlist create(Wishlist wishlist) {
	        return this.wishlistRepository.save(wishlist);
	    }

	    public Optional<Wishlist> findByCustomerId(Long customerId) {
	        return this.wishlistRepository.findByCustomerId(customerId);
	    }

	    public Wishlist addProduct(Set<Product> newProducts, Long id) throws ResourceNotFoundException {
	        Wishlist wishlist = this.wishlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
	        wishlist.getProducts().addAll(newProducts);
	        return wishlist;
	    }

	    public void delete(Long id) {
			Wishlist wishlist = this.wishlistRepository.getReferenceById(id);
	        this.wishlistRepository.delete(wishlist);
	    }
}
