package com.softwareengieering.bellisimo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@CrossOrigin
public interface UserRepository extends CrudRepository<Data_User, Long> {

}