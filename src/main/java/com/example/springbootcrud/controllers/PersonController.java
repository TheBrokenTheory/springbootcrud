package com.example.springbootcrud.controllers;


import com.example.springbootcrud.models.Person;
import com.example.springbootcrud.repositories.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> list() {
        return personRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Person get(@PathVariable Integer id) {
        return personRepository.getOne(id);
    }

    @PostMapping
    public Person create(@RequestBody final Person person) {
        return personRepository.saveAndFlush(person);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        personRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Person update(@PathVariable Integer id, @RequestBody Person person){
        Person existingPerson = personRepository.getById(id);
        BeanUtils.copyProperties(person, existingPerson, "id");
        return personRepository.saveAndFlush(existingPerson);
    }


}
