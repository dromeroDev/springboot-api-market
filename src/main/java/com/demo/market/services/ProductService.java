package com.demo.market.services;

import com.demo.market.dto.ProductDTO;
import com.demo.market.models.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAll();
    List<ProductDTO> findByIdCategory(int idCategory);
    Optional<List<ProductDTO>> getScarseProducts(int quantity);
    Optional<ProductDTO> getProduct(int idProduct);
    ProductDTO save(ProductDTO product);
    boolean delete(int idProduct);
}
