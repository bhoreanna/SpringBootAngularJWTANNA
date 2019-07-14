package com.anna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.User;
@Repository
public interface UserRepository extends CrudRepository<User , String> {

}
