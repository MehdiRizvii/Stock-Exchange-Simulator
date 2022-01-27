package com.example.demo.api;


import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RequestMapping("api/v1/Market")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
/*
    @GetMapping(path = "{price}")
    public List<Person> getPersonByPrice(@PathVariable("price") String price) {
        return personService.getPersonByPrice(price);
    }
*/
    @GetMapping(path = "{id}")
    public List<Person> getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }



    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id")UUID id){
        personService.deletePerson(id);
    }



}