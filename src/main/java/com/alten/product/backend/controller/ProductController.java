package com.alten.product.backend.controller;


import com.alten.product.backend.dto.ProductDto;
import com.alten.product.backend.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getProductById(@PathVariable @NotNull final Long id) {
        return productService.getProductById(id);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto createProduct(@Valid @RequestBody final ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@PathVariable @NotNull final Long id, @Valid @RequestBody final ProductDto productDto) {
        productService.updateProduct(productDto, id);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProductById(@PathVariable @NotNull final Long id) {
        productService.deleteProductById(id);
    }


}
