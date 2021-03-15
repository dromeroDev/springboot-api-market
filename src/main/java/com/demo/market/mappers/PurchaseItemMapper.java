package com.demo.market.mappers;

import com.demo.market.dto.PurchaseItemDTO;
import com.demo.market.models.CompraProductos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            //@Mapping(source = "total", target = "total")
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItemDTO toPurchaseItemDTO(CompraProductos producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    CompraProductos toCompraProductos(PurchaseItemDTO purchaseItem);
}
