package com.example.customer.Controller;

import com.example.customer.Model.Customer;
import com.example.customer.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1/")
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return ResponseEntity.status(200).body(customerList);
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("customer added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@Valid @RequestBody Customer customer, @PathVariable Integer id) {
        customerService.updateCustomer(customer, id);
        return ResponseEntity.status(200).body("customer Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("customer deleted");

    }
}
