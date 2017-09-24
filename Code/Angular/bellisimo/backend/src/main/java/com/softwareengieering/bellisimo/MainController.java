package com.softwareengieering.bellisimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@CrossOrigin
@RequestMapping(path="/data") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	//User requests
	@GetMapping(path="/adduser") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Data_User n = new Data_User ();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "User saved";
	}

	@GetMapping(path="/allusers")
	public @ResponseBody Iterable<Data_User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	//ProductItem requests
	@GetMapping(path="/addproduct") // Map ONLY GET Requests
	public @ResponseBody String addNewProduct (@RequestParam String category
			, @RequestParam String categoryType
			, @RequestParam String categorySubtype
			, @RequestParam String description
			, @RequestParam String size
			, @RequestParam double price
			, @RequestParam String imagePath
	) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		ProductItem n = new ProductItem ();
		n.setCategory(category);
		n.setCategoryType(categoryType);
		n.setCategorySubType(categorySubtype);
		n.setSize(size);
		n.setPrice(price);
		n.setImagePath(imagePath);
		productRepository.save(n);
		return "Product saved";
	}

	@GetMapping(path="/allproducts")
	public @ResponseBody Iterable<ProductItem> getAllProducts() {
		// This returns a JSON or XML with the users
		return productRepository.findAll();
	}
}