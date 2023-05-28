package com.example.customer.Repository;

import com.example.customer.Model.Customer;
import com.example.customer.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository <CustomerDetails, Integer> {

    CustomerDetails findCustomerDetailsById(Integer id);




}
