package com.demo.market.services;

import com.demo.market.dto.ProductDTO;
import com.demo.market.mappers.ProductMapper;
import com.demo.market.models.Producto;
import com.demo.market.repositories.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductoRepository productoRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAll() {
        return productMapper.toProductDTOs(productoRepository.findAll());
    }

    @Override
    public List<ProductDTO> findByIdCategory(int idCategory) {
        return productMapper.toProductDTOs(productoRepository.findByIdCategoria(idCategory));
    }

    @Override
    public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(producto -> productMapper.toProductDTOs(producto));
    }

    @Override
    public Optional<ProductDTO> getProduct(int idProduct) {
        return productoRepository.findById(idProduct).map(producto -> productMapper.toProductDTO(producto));
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        return productMapper.toProductDTO(productoRepository.save(productMapper.toProducto(product)));
    }

    @Override
    public ProductDTO update(ProductDTO product) {
        return productMapper.toProductDTO(productoRepository.save(productMapper.toProducto(product)));
    }

    @Override
    public boolean delete(int idProduct) {
        productoRepository.deleteById(idProduct);
        return productoRepository.findById(idProduct).isEmpty();
    }
}
