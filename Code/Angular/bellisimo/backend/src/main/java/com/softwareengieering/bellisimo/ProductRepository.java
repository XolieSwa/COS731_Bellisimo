package com.softwareengieering.bellisimo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


// This will be AUTO IMPLEMENTED by Spring into a Bean called productRepository
// CRUD refers Create, Read, Update, Delete
@CrossOrigin
public interface ProductRepository extends CrudRepository<ProductItem, Long> {

}