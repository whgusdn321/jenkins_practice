package com.example.productreview.review;

import com.example.productreview.product.Product;
import com.example.productreview.product.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ReviewService {
    private ProductRepository productRepository;
    private ReviewRepository reviewRepository;

    public ReviewService(ProductRepository productRepository,
                         ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    public ReviewDto.Info create(Long productId, Review review) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException());
        review.setProduct(product);
        return new ReviewDto.Info(reviewRepository.save(review));
    }

    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}
