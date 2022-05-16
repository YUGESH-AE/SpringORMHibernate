package com.example;

import com.example.dto.CustomerDto;
import com.example.service.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class SpringOrmHibernateApplication implements CommandLineRunner {

	static Logger logger= LogManager.getLogger(SpringOrmHibernateApplication.class);

	@Autowired
	CustomerServiceImpl customerService;
	public static void main(String[] args) {
		SpringApplication.run(SpringOrmHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		CustomerDto customer1= new CustomerDto(9009009095L, "Debashis", 27, "M", "BBSR", 1);
		CustomerDto customer2= new CustomerDto(9009009094L, "Robert", 27, "M", "PUNE", 2);
		CustomerDto customer3= new CustomerDto(9009009093L, "Lucy", 27, "F", "MUMBAI", 3);

		customerService.insert(customer1);
		customerService.insert(customer2);
		customerService.insert(customer3);
		logger.info("Records are successfully added..");

		logger.info("Enter the phone Number of the Customer which has to be deleted.");

		Long phoneNo=scanner.nextLong();
		int result = customerService.remove(phoneNo);
		if (result == 1) {
			logger.info("Success : Record deleted successfully ");
		} else {
			logger.info("Error : No record found for the given phone number ");
		}

		logger.info("Let's update a Customer with new name details");
		logger.info("Enter the phone number of the Customer to be updated:");
		Long phoneNo1 =  scanner.nextLong();
		logger.info("Enter new name");
		String newName =  scanner.next();
		customerService.update(phoneNo1,newName);
		logger.info("Customer's address updated successfully!");
		scanner.close();

		ArrayList<CustomerDto> cList = (ArrayList<CustomerDto>)customerService.getall();
		for (CustomerDto customer : cList) {
			logger.info(customer);
		}

		logger.info("Display completed");



	}
}
