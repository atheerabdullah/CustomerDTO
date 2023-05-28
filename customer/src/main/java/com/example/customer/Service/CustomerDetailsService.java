package com.example.customer.Service;


import com.example.customer.ApiException.ApiException;
import com.example.customer.DTO.CustomerDetailsDTO;
import com.example.customer.Model.Customer;
import com.example.customer.Model.CustomerDetails;
import com.example.customer.Repository.CustomerDetailsRepository;
import com.example.customer.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;
    private final CustomerRepository customerRepository;

// setter and getter
    public void adDetails(CustomerDetailsDTO dto) {
        Customer customer = customerRepository.findCustomerById(dto.getCustomer_id());

        if (customer == null) {
            throw new ApiException("cant add customer , customer not found ");
        }
        CustomerDetails customerDetails = new CustomerDetails(null, dto.getGender(), dto.getAge(), dto.getEmail(), customer);
        customerDetailsRepository.save(customerDetails);
    }

//    public void updateDetails(CustomerDetailsDTO detailsDTO) {
//        Customer customer = customerRepository.findCustomerById(detailsDTO.getCustomer_id());
//
//        if (customer == null){
//            throw new ApiException("cant add customer, customer not found ");
//        }
//        customerDetailsRepository.
    }

