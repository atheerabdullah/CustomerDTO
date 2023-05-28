package com.example.customer.Controller;

import com.example.customer.DTO.CustomerDetailsDTO;
import com.example.customer.Service.CustomerDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/v1/DetailsCustomer")
@RequiredArgsConstructor
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;



    @PostMapping("/addeDetailsCustomer")
    public ResponseEntity addDetailsCustomer(@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO) {
        customerDetailsService.adDetails(customerDetailsDTO);
        return ResponseEntity.status(200).body("THE details add");
    }

}
