package com.example.jpacustomer.sevice;

import com.example.jpacustomer.model.Customer;
import com.example.jpacustomer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerService implements ICustomerService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    ICustomerRepository customerRepository;


    public List<Customer> findAllDAO() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }


    public List<Customer> showAll() {
        return findAllDAO();
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void save(Customer customer) {
       ;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<Customer> showAllListPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
