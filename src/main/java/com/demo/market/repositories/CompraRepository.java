package com.demo.market.repositories;

import com.demo.market.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
