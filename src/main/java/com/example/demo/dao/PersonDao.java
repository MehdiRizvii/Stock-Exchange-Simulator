package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.Person;

public interface PersonDao {


    List<Person> selectAllPeople();

    int insertPerson(Person person);

    List<Person> selectPersonByPrice(String price);

}