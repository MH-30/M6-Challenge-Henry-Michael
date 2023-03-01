package com.company.customerdataservice.repository;

import com.company.customerdataservice.CustomerDataServiceApplication;
import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CustomerDataServiceApplication.class)
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    @Transactional
    public void testPutCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("LeBron");
        customer.setLastName("James");
        customer.setEmail("justAKidFromAkron@gmail.com");
        customer.setCompany("Los Angeles Lakers");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("Ohio");
        customer.setCity("Akron");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepository.save(customer);

        Optional<Customer> compareCustomer = customerRepository.findById(customer.getCustomerId());

        assertEquals(compareCustomer.get(), customer);

    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("LeBron");
        customer.setLastName("James");
        customer.setEmail("justAKidFromAkron@gmail.com");
        customer.setCompany("Los Angeles Lakers");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("Ohio");
        customer.setCity("Akron");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepository.save(customer);

        customerRepository.deleteById(customer.getCustomerId());
        Optional<Customer> compareCustomer = customerRepository.findById(customer.getCustomerId());
        compareCustomer = customerRepository.findById(customer.getCustomerId());
        assertFalse(compareCustomer.isPresent());
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("LeBron");
        customer.setLastName("James");
        customer.setEmail("justAKidFromAkron@gmail.com");
        customer.setCompany("Los Angeles Lakers");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("Ohio");
        customer.setCity("Akron");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepository.save(customer);

        customer.setPhone("987-654-3210");
        customer.setAddress1("54321 North Street");
        customer.setAddress2("54321 South Street");
        Optional<Customer> compareCustomer = customerRepository.findById(customer.getCustomerId());
        compareCustomer = customerRepository.findById(customer.getCustomerId());
        assertEquals(compareCustomer.get(), customer);
    }

    @Test
    public void testFindCustomerById() {

    }

}
/*
    @Test
    public void testFindCustomerById() {

    }

    @Test
    public void testFindCustomerByState() {

    }

*/
