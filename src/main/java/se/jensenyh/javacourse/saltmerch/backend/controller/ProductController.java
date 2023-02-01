package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3010")
@RequestMapping("api/v1")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/products/{var}")
    public ResponseEntity<Object> getProductCategory(@PathVariable
                                                                        ("var")
                                                            String var){

        switch (var){
            case "hats", "bags", "jackets", "tshirts":
                return new ResponseEntity<>(productService.getProductsByCategory(var), HttpStatus.OK);
            default:
                return new ResponseEntity<>(productService.getProductById(Integer.parseInt(var)), HttpStatus.OK);
        }
    }
}