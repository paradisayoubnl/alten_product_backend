package com.alten.product.backend.dto;

import com.alten.product.backend.model.InventoryStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductDto
        (Long id,
         @NotNull
         String code,
         @NotNull
         String name,
         @NotNull
         String description,
         String image,
         @NotNull
         String category,
         @Min(0)
         Double price,
         Integer quantity,
         String internalReference,
         Long shellId,
         @NotNull
         InventoryStatus inventoryStatus,
         Integer rating
        ) {
}
