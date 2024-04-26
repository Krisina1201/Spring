//package com.example.demo.controller;
//
//import org.springframework.ui.Model;
//import com.example.demo.data.People;
//import com.example.demo.data.Product;
//import com.example.demo.repository.PeopleRepository;
//import com.example.demo.repository.ProductRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.example.demo.service.ProductService;
//import com.example.demo.service.PeopleService;
//
//import java.util.List;
//
//@Controller
//public class frontController {
//
//    private final ProductRepository productRepository;
//    private final PeopleRepository peopleRepository;
//
//    public frontController(ProductRepository productRepository, PeopleRepository peopleRepository) {
//        this.productRepository = productRepository;
//        this.peopleRepository = peopleRepository;
//    }
//
//    @GetMapping("/")
//    public String index(Model model) {
//        return "index";
//    }
//
//    @GetMapping("/products")
//    public String products(Model model) {
//        List<Product> products = productRepository.getAllProducts();
//        model.addAttribute("products", products);
//        return "products";
//    }
//
//    @GetMapping("/peoples")
//    public String peoples(Model model) {
//        // Call the service to get all peoples
//        List<People> peoples = peopleRepository.getAllPeoples();
//        model.addAttribute("peoples", peoples);
//        return "peoples";
//    }
//
//}
