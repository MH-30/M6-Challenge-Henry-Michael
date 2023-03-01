package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //List<Customer> findById(Integer id);
    List<Customer> findByState(String state);


   /* Create a new customer record. 5 pts

    Update an existing customer record. 5 pts

    Delete an existing customer record. 5 pts

    Find a customer record by id. 5 pts

    Find customer records by state. 5 pts*/
}
