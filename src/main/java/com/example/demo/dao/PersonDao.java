package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {


    List<Person> selectAllPeople();

    int insertPerson(Person person);

    UUID id = UUID.randomUUID();

    List<Person> selectPersonByPrice(String price);

}