package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return productRepository.selectAll();
    }

    public List<Product> getProductsByCategory(String category) {

        return productRepository.selectAll(category);
    }

    public Product getProductById(int id) {
        return productRepository.getEntireProduct(id);
    }

    public Product createProduct(Product product) {
        return null;
    }

    public void updateProduct(Product product) {
    }

    public void createVariant(String variant) {

    }

    public void restockVariant(Integer id, String size, String color, Integer quantity) {
    }

    public void deleteProduct( Integer id) {
    }

    public void deleteVariant(Integer productId, Integer variantId) {
    }
}

