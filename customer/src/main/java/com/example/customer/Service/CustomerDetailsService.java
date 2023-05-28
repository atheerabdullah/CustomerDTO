package com.example.customer.Service;


import com.example.customer.ApiException.ApiException;
import com.example.customer.DTO.CustomerDetailsDTO;
import com.example.customer.Model.Customer;
import com.example.customer.Model.CustomerDetails;
import com.example.customer.Repository.CustomerDetailsRepository;
import com.example.customer.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;
    private final CustomerRepository customerRepository;

    // setter and getter

    public List<CustomerDetails> getAllDetails() {
        return customerDetailsRepository.findAll();
    }

    public void adDetails(CustomerDetailsDTO dto) {
        Customer customer = customerRepository.findCustomerById(dto.getCustomer_id());

        if (customer == null) {
            throw new ApiException("cant add customer , customer not found ");
        }
        CustomerDetails customerDetails = new CustomerDetails(null, dto.getGender(), dto.getAge(), dto.getEmail(), customer);
        customerDetailsRepository.save(customerDetails);
    }

    public CustomerDetails updateDetails(CustomerDetailsDTO detailsDTO) {

        // retrieve the CustomerDetails object
        CustomerDetails customerDetails = customerDetailsRepository.findCustomerDetailsById(detailsDTO.getCustomer_id());

        // update the fields of the retrieved CustomerDetails object
        customerDetails.setGender(detailsDTO.getGender());
        customerDetails.setAge(detailsDTO.getAge());
        customerDetails.setEmail(detailsDTO.getEmail());

        // save the updated CustomerDetails object
        return customerDetailsRepository.save(customerDetails);
    }

}