package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Person;

@Repository("fakeDao") // referred to in PersonService
public class FakePersonDataAcessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();// stand in for actual db

    private static List<String> r = new ArrayList<>();

    @Override
    public int insertPerson(Person person) {
        DB.add(new Person(person.getId(),person.getName(), person.getPrice()));
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public List<Person> selectPersonByPrice(String price) {

        List<Person> p = new ArrayList<>();
        Person person = new Person(UUID.randomUUID(),"",price);
        for (Person temp : DB) {
            if (temp.getPrice().equals(price)) {
                p.add(temp);
            }
        }
        return p;
    }



}