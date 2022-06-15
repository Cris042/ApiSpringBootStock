package com.api.parkingcontrol.modules.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.api.parkingcontrol.modules.product.entities.ProductEntities;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntities, UUID> 
{
    boolean existsByName(String userName);
    boolean existsByEmail(String userName);
}
