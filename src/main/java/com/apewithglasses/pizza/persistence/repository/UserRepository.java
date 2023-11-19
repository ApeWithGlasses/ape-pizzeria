package com.apewithglasses.pizza.persistence.repository;

import com.apewithglasses.pizza.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {

}
