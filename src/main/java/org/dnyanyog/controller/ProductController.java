package org.dnyanyog.controller;

import java.sql.SQLException;

import java.util.List;

import org.dnyanyog.dto.Product;
import org.dnyanyog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	Product prod;
	
	@PostMapping(path = "/save")
	public List<String> saveProduct(@RequestBody Product prod) {
		return new ProductService().addProduct(prod);
	}

	@GetMapping(path = "/display")
	public List<String> displayProduct() {
		try {
			return new ProductService().getProduct();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping(path = "/search/{search}")
	public String searchProduct(@PathVariable String search) {
		return new ProductService().search(search);
	}
}
