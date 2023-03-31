package com.company.customerdataservice.repository;

import com.company.customerdataservice.CustomerDataServiceApplication;
import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CustomerDataServiceApplication.class)
public class CustomerRepositoryTest {
   // @MockBean
    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    //@Transactional
    public void testFindByState() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("OH");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepository.save(customer);

        Customer customer2 = new Customer();
        customer2.setCustomerId(2);
        customer2.setFirstName("Rafael");
        customer2.setLastName("Nadal");
        customer2.setEmail("theRagingBull@gmail.com");
        customer2.setCompany("Roland Garros");
        customer2.setPhone("123-456-7890");
        customer2.setAddress1("12345 North Street");
        customer2.setAddress2("12345 South Street");
        customer2.setState("OH");
        customer2.setCity("Columbus");
        customer2.setPostalCode("12345");
        customer2.setCountry("United States of America");

        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setCustomerId(3);
        customer3.setFirstName("Novak");
        customer3.setLastName("Djokovic");
        customer3.setEmail("theDjokerNole@gmail.com");
        customer3.setCompany("Australian Open");
        customer3.setPhone("123-456-7890");
        customer3.setAddress1("12345 North Street");
        customer3.setAddress2("12345 South Street");
        customer3.setState("OH");
        customer3.setCity("Columbus");
        customer3.setPostalCode("12345");
        customer3.setCountry("United States of America");

        customerRepository.save(customer3);

        Customer customer4 = new Customer();
        customer4.setCustomerId(4);
        customer4.setFirstName("Pete");
        customer4.setLastName("Sampras");
        customer4.setEmail("thePistolPete@gmail.com");
        customer4.setCompany("US Open");
        customer4.setPhone("123-456-7890");
        customer4.setAddress1("12345 North Street");
        customer4.setAddress2("12345 South Street");
        customer4.setState("OH");
        customer4.setCity("Columbus");
        customer4.setPostalCode("12345");
        customer4.setCountry("United States of America");

        customerRepository.save(customer4);

        List<Customer> listOfCustomers = customerRepository.findByState("OH");
        assertEquals(4, listOfCustomers.size());
        //System.out.println(customerRepository.findAll());

    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("OH");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepository.save(customer);

        Optional<Customer> findCustomer = customerRepository.findById(1);

        assertEquals(customer, findCustomer.get());

    }

    @Test
    public void testPutCustomerId() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("OH");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepository.save(customer);

        customer.setCountry("Orlando");

        customerRepository.save(customer);

        Optional<Customer> findCustomer = customerRepository.findById(1);

        assertEquals(customer, findCustomer.get());

    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("OH");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customer = customerRepository.save(customer);

        assertEquals(customer, customerRepository.findById(customer.getCustomerId()).get());

    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("OH");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepository.save(customer);

        customerRepository.deleteById(customer.getCustomerId());
        Optional<Customer> deletedCustomer = customerRepository.findById(customer.getCustomerId());
        assertFalse(deletedCustomer.isPresent());
    }




}
