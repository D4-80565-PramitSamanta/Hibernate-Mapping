package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Person;

public interface UserRepo extends JpaRepository<Person, Integer>{

}
