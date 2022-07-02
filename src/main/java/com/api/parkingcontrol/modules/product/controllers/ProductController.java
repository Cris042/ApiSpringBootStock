package com.api.parkingcontrol.modules.product.controllers;


import com.api.parkingcontrol.modules.product.dtos.ProductDto;
import com.api.parkingcontrol.modules.product.entities.ProductEntities;
import com.api.parkingcontrol.modules.product.services.ProductService;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employee")

public class ProductController
{
    final ProductService productService;

    public ProductController(ProductService productService) 
    {
        this.productService = productService;
    }


    @PostMapping("add")
    public ResponseEntity<Object> saveProduct(@ModelAttribute @Valid ProductDto productDto){
        if(productService.existsByName(productDto.getName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name is already in use!");
        }
        var productEntities = new ProductEntities();
        BeanUtils.copyProperties(productDto, productEntities);  
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productEntities));
    }


    @GetMapping("all")
    public ResponseEntity<Page<ProductEntities>> getAllProduct(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pageable));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<ProductEntities> ProductEntitiesOptional = productService.findById(id);
        if (!ProductEntitiesOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        productService.delete(ProductEntitiesOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductDto productDto)
    {
        Optional<ProductEntities> ProductEntitiesOptional = productService.findById(id);
        if (!ProductEntitiesOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var ProductEntities = new ProductEntities();
        BeanUtils.copyProperties(productDto, ProductEntities);
        ProductEntities.setId(ProductEntitiesOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(ProductEntities));
    }
}
