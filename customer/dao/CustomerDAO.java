package com.sachin.customer.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.sachin.customer.dto.CustomerDTO;

public interface CustomerDAO {

	int save(CustomerDTO dto);

	void saveAll(Collection<CustomerDTO> collection);

	Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate);

	Collection<CustomerDTO> findAll();

	Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate);

	Collection<CustomerDTO> findAllSortNameDesc();

	int total();

}
