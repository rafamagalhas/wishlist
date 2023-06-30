package com.rafamagalhas.wishlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rafamagalhas.wishlist.exception.ResourceNotFoundException;
import com.rafamagalhas.wishlist.model.Product;
import com.rafamagalhas.wishlist.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    public List<Product> getAll() {
        return new ArrayList<>(productRepository.findAll());

    }

    public Product update(Product newProduct, Long id) throws ResourceNotFoundException {
        Optional<Product> optionalProduct = this.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ResourceNotFoundException(""));
        product.setTitle(newProduct.getTitle());
        product.setPrice(newProduct.getPrice());
        return product;
    }

    @Transactional
    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Product> optionalProduct = this.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ResourceNotFoundException(""));
        this.productRepository.delete(product);
    }
}
