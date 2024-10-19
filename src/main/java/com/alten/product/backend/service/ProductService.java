package com.alten.product.backend.service;

import com.alten.product.backend.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto createProduct(final ProductDto productDto);

    void updateProduct(final ProductDto productDto, final Long id);

    ProductDto getProductById(final Long id);

    void deleteProductById(final Long id);
}
