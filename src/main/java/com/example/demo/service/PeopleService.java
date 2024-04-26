package com.example.demo.service;


import com.example.demo.data.People;
import com.example.demo.data.Product;
import com.example.demo.repository.PeopleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People savePeople(People people) {
        return peopleRepository.save(people);
    }

    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    public Optional<People> getPeopleById(Long id) {
        return peopleRepository.findById(id);
    }

    public List<Product> getAllOrdersByPersonId(Long personId) {
        People people = peopleRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + personId));
        return people.getProducts();
    }

//    public List<People> getAllCustomersByProductId(Long productId) {
//        Product product = productService.getProductById(productId);
//        return product.getPerson();
//    }

    public People updatePeople(Long id, People updatePeople) {
        Optional<People> existingPeople = peopleRepository.findById(id);
        if (existingPeople.isPresent()) {
            People people = existingPeople.get();
            people.setName(updatePeople.getName());
            //people.setProductId(updatePeople.getProductId());
            return peopleRepository.save(people);
        } else {
            throw new RuntimeException("People hot found");
        }
    }

    public void deletePeople(Long id) {
        peopleRepository.deleteById(id);
    }
}
