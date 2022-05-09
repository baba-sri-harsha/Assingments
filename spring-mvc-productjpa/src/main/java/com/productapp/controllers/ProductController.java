package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;
@Controller
public class ProductController {
	
    private IProductService productService;
    
    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
    
    @RequestMapping("/search")
    public String search(@RequestParam("choice") String choice,ModelMap map) throws ProductNotFoundException {
        List<Product> products=productService.getByChoice(choice);
        map.addAttribute("products",products);
        return "home";
    }

	@RequestMapping("/")
    public String home(ModelMap map) {
        List<Product> products=productService.getAll();
        map.addAttribute("products", products);
        return "home";
    }
    
    @RequestMapping("/addProduct")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "admin";
    }
    
   
    
    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId")int productId) {
        productService.deleteProduct(productId);
        return "admin";
    }
    
    @RequestMapping("/getOneProduct")
    public String getOne(@RequestParam("productId")int productId,Model model) throws ProductNotFoundException {
    Product product=productService.getById(productId);
    model.addAttribute("product", product);
    return "update";
    }
    
    @RequestMapping("/updateProduct")
    public String updateProduct(Product product) {
    productService.updateProduct(product);
    return "admin";
    }

}