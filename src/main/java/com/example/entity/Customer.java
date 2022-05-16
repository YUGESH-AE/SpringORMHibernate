package com.example.entity;

import com.example.dto.CustomerDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "phone_no", nullable = false)
    private Long phoneNo;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    @Column(name = "plan_id")
    private Integer planId;

    public static CustomerDto customerDtoEntity(Customer customer){
        CustomerDto a=new CustomerDto();
        a.setPhoneNo(customer.getPhoneNo());
        a.setName(customer.getName());
        a.setAge(customer.getAge());
        a.setGender(customer.getGender());
        a.setAddress(customer.getAddress());
        a.setPlanId(customer.getPlanId());
        return  a;
    }
}