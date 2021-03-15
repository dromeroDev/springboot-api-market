package com.demo.market.services;

import com.demo.market.dto.PurchaseDTO;
import com.demo.market.mappers.PurchaseMapper;
import com.demo.market.models.Compra;
import com.demo.market.repositories.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final CompraRepository compraRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public List<PurchaseDTO> getAll() {
        return purchaseMapper.toPurchasesDTO(compraRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDTO>> getByIdClient(String clientId) {
        return compraRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchasesDTO(compras));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        //Seteo la compra en cada producto para que se guarden en cascada
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return purchaseMapper.toPurchaseDTO(compraRepository.save(compra));
    }
}
