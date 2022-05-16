package com.example.service;

import com.example.dto.CustomerDto;
import com.example.entity.Customer;
import com.example.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerRepositoryImpl customerRepository;

    public void insert(CustomerDto customerDto){
        customerRepository.insert(CustomerDto.customerEntity(customerDto));
    }
    public int remove(Long phoneNo){
        return customerRepository.remove(phoneNo);
    }

    public void update(Long phoneNo,String name){
        customerRepository.update(phoneNo, name);
    }

    public List<CustomerDto> getall(){
        List<CustomerDto> custList=new ArrayList<>();

        List<Customer>customerList=customerRepository.getall();

        for (Customer c:customerList){
            CustomerDto customerDto=Customer.customerDtoEntity(c);
            custList.add(customerDto);
        }
        return custList;
    }

}
