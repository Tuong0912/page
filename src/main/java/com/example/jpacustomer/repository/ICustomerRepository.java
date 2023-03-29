package com.example.jpacustomer.repository;

import com.example.jpacustomer.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
