package com.example.dto;

import com.example.entity.Customer;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDto implements Serializable {
    private Long phoneNo;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private Integer planId;

    public static Customer customerEntity(CustomerDto customerDto){
        Customer a=new Customer();
        a.setPhoneNo(customerDto.getPhoneNo());
        a.setName(customerDto.getName());
        a.setAge(customerDto.getAge());
        a.setGender(customerDto.getGender());
        a.setAddress(customerDto.getAddress());
        a.setPlanId(customerDto.getPlanId());
        return  a;
    }
}
