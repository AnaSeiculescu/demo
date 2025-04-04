package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.dto.CreateProductDto;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String getProducts(Model model) {
        List<Product> productList = productService.getProducts();
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> providers = productService.findProductsByName(name);
        System.out.println("Search results for '" + name + "': " + providers);
        model.addAttribute("providers", providers);
        return "searchResults";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProductById(id);
        return "home";
    }

    @PostMapping("/createProduct")
    public String createProductForm(@ModelAttribute @Valid CreateProductDto createProductDto) {
        productService.createProduct(createProductDto);
        return "redirect:/";
    }

    @GetMapping("/productForm")
    public String getProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }
}
