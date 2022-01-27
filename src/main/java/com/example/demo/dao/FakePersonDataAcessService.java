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
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName(), person.getPrice()));
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public List<Person> selectPersonById(UUID id) {
        List<Person> x = new ArrayList<>();
        Person person = new Person(id,"","");
        for (Person temps : DB) {
            if (temps.getId().equals(id)) {
                x.add(temps);
            }
        }
        return x;
    }



    @Override
    public int deletePersonById(UUID id) {
        List<Person> personMaybe = selectPersonById(id);
        DB.remove(personMaybe.get(0));
        return 1;
    }


/*
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
*/

}