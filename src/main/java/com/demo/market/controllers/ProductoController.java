package com.demo.market.controllers;

import com.demo.market.models.Producto;
import com.demo.market.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("productos")
    public List<Producto> getAll() {
        return productoService.getAll();
    }

}
