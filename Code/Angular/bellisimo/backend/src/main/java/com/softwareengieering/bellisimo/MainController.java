package com.softwareengieering.bellisimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller    // This means that this class is a Controller
@CrossOrigin
@RequestMapping(path="/data") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

    // ************************ PRODUCT METHODS ****************************************
    // -------------------Retrieve All Products------------------------------------------
	@GetMapping(path="/allproducts")
	public @ResponseBody Iterable<ProductItem> getAllProducts() {
		// This returns a JSON or XML with the users
		return productRepository.findAll();
	}

    // -------------------Retrieve Single Product------------------------------------------

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public @ResponseBody ProductItem getProduct( @PathVariable("id") long id ) {
        ProductItem product = productRepository.findOne ( id );
        if (product == null) {
            return null;
        }
        return product;
    }
    // -------------------Create a Product-------------------------------------------
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public ResponseEntity <?> createProduct ( @RequestBody ProductItem product , UriComponentsBuilder ucBuilder ) {

        /*
        if (productService.isProductExist(product)) {
            logger.error("Unable to create. A Product with name {} already exist", product.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Product with name " +
                    product.getName() + " already exist."),HttpStatus.CONFLICT);
        }*/
        productRepository.save (product);
        HttpHeaders headers = new HttpHeaders ();
        headers.setLocation ( ucBuilder.path ( "/data/product/{id}" ).buildAndExpand ( product.getId () ).toUri () );
        return new ResponseEntity <String> ( headers , HttpStatus.CREATED );
    }

    // ------------------- Update a Product ------------------------------------------------

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody ProductItem product) {
        ProductItem currentProduct = productRepository.findOne(id);
        if (currentProduct == null) {
            return new ResponseEntity("Product to update not found",
                    HttpStatus.NOT_FOUND);
        }
        currentProduct.setCategory (product.getCategory ());
        currentProduct.setCategoryType(product.getCategoryType());
        currentProduct.setCategorySubType(product.getCategorySubType());
        currentProduct.setDescription (product.getDescription ());
        currentProduct.setSize (product.getSize ());
        currentProduct.setPrice (product.getPrice());
        currentProduct.setImagePath ( product.getImagePath ());

        productRepository.save (currentProduct);
        return new ResponseEntity<ProductItem>(currentProduct, HttpStatus.OK);
    }

    // ------------------- Delete a Product-----------------------------------------
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
    /* logger.info("Fetching & Deleting Product with id {}", id);*/
        ProductItem product = productRepository.findOne(id);
        if (product == null) {
            return new ResponseEntity("Product to delete not found",
                    HttpStatus.NOT_FOUND);
        }
        productRepository.delete(id);
        return new ResponseEntity<ProductItem>(HttpStatus.NO_CONTENT);
    }



    // ************************ USER METHODS ****************************************
    // -------------------Retrieve All Users------------------------------------------
    @GetMapping(path="/allusers")
    public @ResponseBody Iterable<UserItem> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    // -------------------Retrieve Single User------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody UserItem getUser( @PathVariable("id") long id ) {
        UserItem user = userRepository.findOne ( id );
        if (user == null) {
            return null;
        }
        return user;
    }
    // -------------------Create a User-------------------------------------------
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseEntity <?> createUser ( @RequestBody UserItem user , UriComponentsBuilder ucBuilder ) {
        userRepository.save (user);
        HttpHeaders headers = new HttpHeaders ();
        headers.setLocation ( ucBuilder.path ( "/data/user/{id}" ).buildAndExpand ( user.getId () ).toUri () );
        return new ResponseEntity <String> ( headers , HttpStatus.CREATED );
    }

    // ------------------- Update a User ------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserItem user) {
        UserItem currentUser = userRepository.findOne(id);
        if (currentUser == null) {
            return new ResponseEntity("User to update not found",
                    HttpStatus.NOT_FOUND);
        }
        currentUser.setName(user.getName ());
        currentUser.setSurname(user.getSurname());
        currentUser.setPassword (user.getPassword ());
        currentUser.setEmail(user.getEmail ());
        currentUser.setAdmin (user.isAdmin());
        userRepository.save (currentUser);
        return new ResponseEntity<UserItem>(currentUser, HttpStatus.OK);
    }

    // ------------------- Delete a User-----------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        UserItem user = userRepository.findOne(id);
        if (user == null) {
            return new ResponseEntity("User to delete not found",
                    HttpStatus.NOT_FOUND);
        }
        userRepository.delete(id);
        return new ResponseEntity<UserItem>(HttpStatus.NO_CONTENT);
    }
}