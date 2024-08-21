package com.nexential.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nexential.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {

}
