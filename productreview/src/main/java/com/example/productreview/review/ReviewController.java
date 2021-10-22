package com.example.productreview.review;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/{productId}/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("")
    public ReviewDto.Info createReview(@PathVariable("productId") Long productId,
                               @RequestBody Review review) {
        return reviewService.create(productId, review);
    }

    @DeleteMapping("/{id}")
    public void createReview(@PathVariable("productId") Long productId,
                             @PathVariable("id") Long id) {
        reviewService.delete(id);
    }
}
