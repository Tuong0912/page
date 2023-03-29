package com.example.jpacustomer.sevice;

import com.example.jpacustomer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralRepository<Customer> {

    Page<Customer> showAllListPage(Pageable pageable);
}
