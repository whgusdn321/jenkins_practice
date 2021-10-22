package com.example.productreview.product;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product newProduct) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        return productRepository.save(product);
    }
}
