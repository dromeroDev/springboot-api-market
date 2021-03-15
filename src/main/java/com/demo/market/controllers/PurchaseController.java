package com.demo.market.controllers;

import com.demo.market.dto.ProductDTO;
import com.demo.market.dto.PurchaseDTO;
import com.demo.market.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDTO>> getByIdClient(@PathVariable("id") String clientId) {
        return purchaseService.getByIdClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}