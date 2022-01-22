package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{price}")
    public Person getPersonById(@PathVariable("price") BigDecimal price){
        return personService.getPersonByPrice(price)                  //after sending a get request with that price we will either return the person, OR if they don't exisist we return null
                .orElse(null);
    }
    @DeleteMapping(path = "{price}")
    public void deletePersonByPrice(@PathVariable("price") BigDecimal price){
        personService.deletePerson(price);
    }
    @PutMapping(path = "{price}")
    public void updatePerson(@PathVariable("price") BigDecimal price, @Valid @NotNull @RequestBody Person personToUpdate){
        personService.updatePerson(price, personToUpdate);
    }

}
