package com.apewithglasses.pizza.web.controller;

import com.apewithglasses.pizza.persistence.entity.CustomerEntity;
import com.apewithglasses.pizza.persistence.entity.OrderEntity;
import com.apewithglasses.pizza.services.CustomerService;
import com.apewithglasses.pizza.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    @Autowired
    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone(@PathVariable String phone) {
        CustomerEntity customer = customerService.findByPhone(phone);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String id) {
        return ResponseEntity.ok().body(this.orderService.getCustomerOrders(id));
    }
}
