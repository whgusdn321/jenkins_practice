package com.example.productreview.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Info {
        private Long id;
        private String name;
        private Integer price;

        public Info(Product product) {
            this.id = product.getId();
            this.name = product.getName();
            this.price = product.getPrice();
        }
    }
}
