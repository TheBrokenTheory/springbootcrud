package com.example.springbootcrud.repositories;

import com.example.springbootcrud.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {



}
