package com.example.demo.dao;

import com.example.demo.model.Person;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//actual interface where we can define our operations allowed/contract for anyone who wants to implement this interface; and using dependecy injection we can change db easily
public interface PersonDao {

    int insertPerson(BigDecimal price, Person person);   //allows us to insert a person with a given price

    default int insertPerson(Person person){
        BigDecimal price = new BigDecimal("0");        //without an price, its randomly generated
        return insertPerson(price, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonByPrice(BigDecimal price);

    int deletePersonByPrice(BigDecimal price);

    int updatePersonByPrice(BigDecimal price, Person person);


}
