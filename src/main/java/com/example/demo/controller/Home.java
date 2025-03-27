//package com.example.demo.controller;
//
//import com.example.demo.model.Product;
//import com.example.demo.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class Home {
//    private final ProductService productService;
//    @GetMapping("/")
//    public String getHome(Model model) {
//        List<Product> productList = productService.getProducts();
//        model.addAttribute("productList", productList);
//        return "home";
//    }
//
//}
