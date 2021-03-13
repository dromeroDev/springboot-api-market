package com.demo.market.controllers;

import com.demo.market.dto.ProductDTO;
import com.demo.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductDTO> getById(@PathVariable("id") int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public List<ProductDTO> getByIdCategory(@PathVariable("id") int categoryId) {
        return productService.findByIdCategory(categoryId);
    }

    @PostMapping()
    public ProductDTO save(@RequestBody ProductDTO product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int productId) {
        return productService.delete(productId);
    }

}
