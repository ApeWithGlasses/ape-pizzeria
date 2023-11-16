package com.apewithglasses.pizza.persistence.repository;

import com.apewithglasses.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {

}
