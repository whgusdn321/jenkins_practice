package com.example.productreview.review;

import com.example.productreview.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ReviewDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Info {
        private Long id;
        private String content;
        private ProductDto.Info product;

        public Info(Review review) {
            this.id = review.getId();
            this.content = review.getContent();
            this.product = new ProductDto.Info(review.getProduct());
        }

        public Review toEntity() {
            return Review.builder()
                    .id(id)
                    .content(content)
                    .build();
        }
    }
}
