package com.alten.product.backend.service;

import com.alten.product.backend.dto.ProductDto;
import com.alten.product.backend.model.InventoryStatus;
import com.alten.product.backend.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest {

    @Test
    void shouldMapProduct() {
        ProductDto productDto = ProductDto.builder()
                .id(1L)
                .name("name")
                .code("code")
                .description("description")
                .image("image")
                .category("category")
                .price(25.0)
                .quantity(3)
                .internalReference("internalReference")
                .shellId(123L)
                .inventoryStatus(InventoryStatus.INSTOCK)
                .rating(5)
                .build();

        Product product = ProductMapper.mapToProduct(productDto);

        assertEquals(product.getName(), productDto.name());
        assertEquals(product.getCode(), productDto.code());
        assertEquals(product.getDescription(), productDto.description());
        assertEquals(product.getImage(), productDto.image());
        assertEquals(product.getCategory(), productDto.category());
        assertEquals(product.getPrice(), productDto.price());
        assertEquals(product.getQuantity(), productDto.quantity());
        assertEquals(product.getInternalReference(), productDto.internalReference());
        assertEquals(product.getShellId(), productDto.shellId());
        assertEquals(product.getInventoryStatus(), productDto.inventoryStatus());
        assertEquals(product.getRating(), productDto.rating());

    }

    @Test
    void shouldMapProductDto() {
        Product product = new Product();
        product.setId(1L);
        product.setName("name");
        product.setCode("code");
        product.setDescription("description");
        product.setImage("image");
        product.setCategory("category");
        product.setPrice(25.0);
        product.setQuantity(3);
        product.setInternalReference("internalReference");
        product.setShellId(123L);
        product.setInventoryStatus(InventoryStatus.INSTOCK);
        product.setRating(5);
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());

        ProductDto productDto = ProductMapper.mapToProductDto(product);

        assertEquals(product.getName(), productDto.name());
        assertEquals(product.getCode(), productDto.code());
        assertEquals(product.getDescription(), productDto.description());
        assertEquals(product.getImage(), productDto.image());
        assertEquals(product.getCategory(), productDto.category());
        assertEquals(product.getPrice(), productDto.price());
        assertEquals(product.getQuantity(), productDto.quantity());
        assertEquals(product.getInternalReference(), productDto.internalReference());
        assertEquals(product.getShellId(), productDto.shellId());
        assertEquals(product.getInventoryStatus(), productDto.inventoryStatus());
        assertEquals(product.getRating(), productDto.rating());

    }
}
