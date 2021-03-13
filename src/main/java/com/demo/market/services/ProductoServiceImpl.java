package com.demo.market.services;

import com.demo.market.models.Producto;
import com.demo.market.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> findByIdCategoria(int idCategoria) {
        return productoRepository.findByIdCategoria(idCategoria);
    }

    @Override
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    @Override
    public Optional<Producto> getProducto(int idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void delete(int idProducto) {
        productoRepository.deleteById(idProducto);
    }
}
