package com.demo.market.services;

import com.demo.market.models.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> getAll();
    List<Producto> findByIdCategoria(int idCategoria);
    Optional<List<Producto>> getEscasos(int cantidad);
    Optional<Producto> getProducto(int idProducto);
    Producto save(Producto producto);
    void delete(int idProducto);
}
