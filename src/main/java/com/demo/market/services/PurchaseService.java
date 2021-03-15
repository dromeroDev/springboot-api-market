package com.demo.market.services;

import com.demo.market.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    List<PurchaseDTO> getAll();
    Optional<List<PurchaseDTO>> getByIdClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchase);
}
