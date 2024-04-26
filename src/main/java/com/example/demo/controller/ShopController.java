package com.example.demo.controller;


import com.example.demo.data.People;
import com.example.demo.data.Product;
import com.example.demo.service.PeopleService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ShopController {

    private final ProductService productService;
    private final PeopleService peopleService;

    @Autowired
    public ShopController(ProductService productService, PeopleService peopleService) {
        this.productService = productService;
        this.peopleService = peopleService;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/peoples")
    public List<People> getAllPeople() {
        return peopleService.getAllPeople();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @PostMapping("/peoples")
    public ResponseEntity<People> saveProduct(@RequestBody People people) {
        People newPeople = peopleService.savePeople(people);
        return ResponseEntity.ok(newPeople);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductId(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/peoples/{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable Long id) {
        Optional<People> people = peopleService.getPeopleById(id);
        return people.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<People> updatePeople(@PathVariable Long id, @RequestBody People people) {
        People updatedPeople = peopleService.updatePeople(id, people);
        return ResponseEntity.ok(updatedPeople);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<String> deletePeople(@PathVariable Long id) {
        peopleService.deletePeople(id);
        return ResponseEntity.ok("People deleted successfully");
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/{personId}/orders")
    public ResponseEntity<List<Product>> getAllOrdersByPersonId(@PathVariable Long personId) {
        List<Product> orders = peopleService.getAllOrdersByPersonId(personId);
        return ResponseEntity.ok(orders);
    }
//    @GetMapping("/{productId}/customers")
//    public ResponseEntity<List<People>> getAllCustomersByProductId(@PathVariable Long productId) {
//        List<People> customers = peopleService.getAllCustomersByProductId(productId);
//        return ResponseEntity.ok(customers);
//    }
}

