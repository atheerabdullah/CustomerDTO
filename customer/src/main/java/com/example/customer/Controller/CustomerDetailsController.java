package com.example.customer.Controller;

import com.example.customer.DTO.CustomerDetailsDTO;
import com.example.customer.Model.CustomerDetails;
import com.example.customer.Service.CustomerDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1/DetailsCustomer")
@RequiredArgsConstructor
public class CustomerDetailsController {


    private final CustomerDetailsService customerDetailsService;


    @GetMapping("/getAllDetails")
    public ResponseEntity<List<CustomerDetails>> getAllDetails() {
        List<CustomerDetails> customerDetailsList = customerDetailsService.getAllDetails();
        return ResponseEntity.status(200).body(customerDetailsList);

    }

    @PostMapping("/addeDetailsCustomer")
    public ResponseEntity addDetailsCustomer(@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO) {
        customerDetailsService.adDetails(customerDetailsDTO);
        return ResponseEntity.status(200).body("THE details add");
    }


    @PutMapping("/updateDetailsCustomer/{id}")
    public ResponseEntity updateDetailsCustomer(@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO, @PathVariable Integer id) {
        customerDetailsService.updateDetails(customerDetailsDTO);
        return ResponseEntity.status(200).body("the customer Details has been changed ");
    }


}
