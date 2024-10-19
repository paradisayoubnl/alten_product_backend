package com.alten.product.backend.service;

import com.alten.product.backend.dto.ProductDto;
import com.alten.product.backend.exception.ProductNotFoundException;
import com.alten.product.backend.model.Product;
import com.alten.product.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
    }

    public ProductDto createProduct(final ProductDto productDto) {
        return ProductMapper.mapToProductDto(productRepository.save(ProductMapper.mapToProduct(productDto)));
    }

    public void updateProduct(final ProductDto productDto, final Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
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
        productRepository.save(product);
    }

    public ProductDto getProductById(final Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::mapToProductDto)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProductById(final Long id) {
        productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.deleteById(id);
    }
}
