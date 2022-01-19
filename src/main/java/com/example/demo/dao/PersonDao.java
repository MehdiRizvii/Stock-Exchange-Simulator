package com.example.demo.dao;

import com.example.demo.model.Person;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//actual interface where we can define our operations allowed/contract for anyone who wants to implement this interface; and using dependecy injection we can change db easily
public interface PersonDao {

    int insertPerson(UUID id, Person person);   //allows us to insert a person with a given id

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();        //without an id, its randomly generated
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);


}
