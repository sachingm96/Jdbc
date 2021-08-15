package com.sachin.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import com.sachin.customer.constant.Education;
import com.sachin.customer.dao.CustomerDAO;
import com.sachin.customer.dao.CustomerDAOImpl;
import com.sachin.customer.dto.CustomerDTO;
import com.sachin.customer.service.CustomerService;
import com.sachin.customer.service.CustomerServiceImpl;

public class CustomerTester {

	public static void main(String[] args) {

	CustomerDTO dto = new CustomerDTO("sanjay", "bangalore", "mysore", "3rd main basveshwaranagar bangalore", false,
			1234567890, Education.BE);
		CustomerDTO dto1 = new CustomerDTO("akshay", "davanagere", "bangalore", "2nd main gandhinagar davanagere", true,
				1458903900, Education.BBA);
		CustomerDTO dto2 = new CustomerDTO("suresh", "mysore", "mysore", "6th main thilak nagar mysore", true,
				1575567889, Education.MBBS);
		CustomerDTO dto3 = new CustomerDTO("ramesh", "bangalore", "banaglore", "8th main peenya bangalore", false,
				1345446444, Education.MBA);
		CustomerDTO dto4 = new CustomerDTO("sandesh", "shimoga", "hasan", "3rd main kuvempu road shimoga", false,
				1759696969, Education.MSC);
		
		CustomerDAO dao = new CustomerDAOImpl();
		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto4);
		
		
		CustomerService cust = new CustomerServiceImpl();
		cust.save(dto);
		cust.save(dto1);
		cust.save(dto2);
		cust.save(dto3);
		cust.save(dto4);

		Collection<CustomerDTO> coll = Arrays.asList(dto, dto1, dto2, dto3, dto4);
		cust.saveAll(coll);
		
		System.out.println("****************************************************");
		Optional<CustomerDTO> findOne = cust.findOne(a -> a.getName().equals("sanjay"));
		if (findOne.isPresent()) {
			CustomerDTO name = findOne.get();
			System.out.println(name);
		}

		System.out.println("****************************************************");
		
		Collection<CustomerDTO> findAll = cust.findAll();
		findAll.forEach(a -> System.out.println(a));
		
		System.out.println("****************************************************");
		
		Collection<CustomerDTO> findall = cust.findAll(b -> b.getAddress().equals("bangalore"));
		findall.forEach(s -> System.out.println(s));//getFrom().endsWith("e")
		
		System.out.println("****************************************************");
		
		Collection<CustomerDTO> nameDesc = cust.findAllSortNameDesc();
		nameDesc.forEach(n -> System.out.println(n));
		
		System.out.println("****************************************************");
		
		int total = cust.total();
		System.out.println(total);
		

	}

}
