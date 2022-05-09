package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class AdminController {
	
	@Autowired
	IProductService iProductService;

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
    
    
    @RequestMapping("/addForm")
    public String showAddForm() {
        return "addProductForm";
    }
    
    @RequestMapping("/deleteForm")
    public String showDeleteForm() {
        return "deleteForm";
    }
    
    @RequestMapping("/editForm")
    public String showeditForm() {
        return "editForm";
    }
    
    @RequestMapping("/home")
    public String home(ModelMap map) {
    	List<Product > products = iProductService.getAll();
		map.addAttribute("products",products);
    	return "home";
    }
}