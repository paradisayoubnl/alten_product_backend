package com.alten.product.backend.service;

import com.alten.product.backend.dto.ProductDto;
import com.alten.product.backend.model.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .code(product.getCode())
                .description(product.getDescription())
                .image(product.getImage())
                .category(product.getCategory())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .internalReference(product.getInternalReference())
                .shellId(product.getShellId())
                .inventoryStatus(product.getInventoryStatus())
                .rating(product.getRating())
                .build();
    }


    public static Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.name());
        product.setCode(productDto.code());
        product.setDescription(productDto.description());
        product.setImage(productDto.image());
        product.setCategory(productDto.category());
        product.setPrice(productDto.price());
        product.setQuantity(productDto.quantity());
        product.setInternalReference(productDto.internalReference());
        product.setShellId(productDto.shellId());
        product.setInventoryStatus(productDto.inventoryStatus());
        product.setRating(productDto.rating());
        return product;
    }
}
