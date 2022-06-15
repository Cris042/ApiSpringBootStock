package com.api.parkingcontrol.modules.product.services;

import com.api.parkingcontrol.modules.product.entities.ProductEntities;
import com.api.parkingcontrol.modules.product.repositories.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService 
{
    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductEntities save(ProductEntities productEntities) {
        return productRepository.save(productEntities);
    }

    public boolean existsByEmail(String email) {
        return productRepository.existsByEmail( email);
    }

    public boolean existsByName(String name) {
        return productRepository.existsByName( name );
    }


    public Page<ProductEntities> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<ProductEntities> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void delete(ProductEntities productEntities) {
        productRepository.delete(productEntities);
    }
}
