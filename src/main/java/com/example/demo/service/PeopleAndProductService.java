package com.example.demo.service;


import com.example.demo.data.People;
import com.example.demo.data.Product;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleAndProductService {
    private final ProductRepository productRepository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleAndProductService(ProductRepository productRepository, PeopleRepository peopleRepository) {
        this.productRepository = productRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Product> getAllOrdersByPersonId(Long personId) {
        People people = peopleRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + personId));
        return people.getProducts();
    }

//    public List<People> getAllCustomersByProductId(Long productId) {
//        Product product = productRepository.getProductById(productId);
//        return product.getPerson();
//    }

}
