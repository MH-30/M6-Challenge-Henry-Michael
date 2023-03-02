package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerRepository customerRepository;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of customer for testing purposes
    private List<Customer> customerList;

    @Before
    public void setUp() {
        customerList = new ArrayList<Customer>();
    }

    // Testing Updating

    @Test
    public void shouldReturnCustomerByUpdate() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("Ohio");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");
        customer.setCustomerId(2);
        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customers").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    // Testing Create A Customer
    @Test
    public void shouldReturnNewCustomerOnPostRequest() throws Exception {
        // ARRANGE
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("Ohio");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(customer);

        // ACT
        mockMvc.perform(
                        post("/customers")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    // Test Deleting A Customer
    @Test
    public void shouldReturnADeletedCustomer() throws Exception {
        // ACT
        mockMvc.perform(
                        delete("/customers/1"))                          // Perform the POST reque
                .andDo(print())                                // Print results to console
                .andExpect(status().isNoContent());              // ASSERT (status code is 201)
    }

    // Test Getting A Customer By ID
    @Test
    public void shouldReturnACustomerById() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("Ohio");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        String outputJson = mapper.writeValueAsString(customer);


        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    // Test Get Customers by State
    @Test
    public void shouldReturnCustomerByState() throws Exception{
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Roger");
        customer.setLastName("Federer");
        customer.setEmail("theSwissMaestro@gmail.com");
        customer.setCompany("Wimbledon");
        customer.setPhone("123-456-7890");
        customer.setAddress1("12345 North Street");
        customer.setAddress2("12345 South Street");
        customer.setState("Ohio");
        customer.setCity("Columbus");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        String outputJson = mapper.writeValueAsString(customer);
        mockMvc.perform(MockMvcRequestBuilders.get("/customers/state/Ohio"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}