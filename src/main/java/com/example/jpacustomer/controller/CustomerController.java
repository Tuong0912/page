package com.example.jpacustomer.controller;

import com.example.jpacustomer.model.Customer;
import com.example.jpacustomer.sevice.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Customer> customers = this.customerService.findAll();
        model.addAttribute("customer", customers);
        return "/customer/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("{id}/editForm")
    public String editForm(@PathVariable Long id, Model model) {
        Customer customer = this.customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "/customer/edit";
        } else return "redirect:/customer";
    }

    @PostMapping("edit")
    public String editCustomer(@ModelAttribute Customer customer) {
        this.customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("{id}/delete")
    public String deleteCustomer(@PathVariable Long id){
            this.customerService.delete(id);
            return "redirect:/customer";
    }


    @RequestMapping("findAll")
    public String showAll(@PageableDefault(value = 1) Pageable pageable, Model model){
        Page<Customer> customers = customerService.showAllListPage(pageable);
        model.addAttribute("customer", customers);
        return "/customer/list";
    }
}
