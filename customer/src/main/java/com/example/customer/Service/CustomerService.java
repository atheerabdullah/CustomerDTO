package com.example.customer.Service;

import com.example.customer.ApiException.ApiException;
import com.example.customer.Model.Customer;
import com.example.customer.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer,Integer id){
        Customer oldCustomer= customerRepository.findCustomerById(id);
        if(oldCustomer==null) {

            throw new ApiException("the customer not updated ");
        }
        oldCustomer.setName(customer.getName());
        customerRepository.save(oldCustomer);
    }


    public void deleteCustomer(Integer id){
        Customer customer= customerRepository.findCustomerById(id);
        if(customer==null){
            throw new ApiException("the customer not found ");
        }

        customerRepository.delete(customer);
    }



}
