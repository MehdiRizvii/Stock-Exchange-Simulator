package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao") //class serves as a repository
public class FakePersonDataAcessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(BigDecimal price, Person person) {
        DB.add(new Person(price, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonByPrice(BigDecimal price) {
        return DB.stream()
                .filter(person -> person.getPrice().equals(price))            //filters through the people and checks our DB to see if that person with that price exists
                .findFirst();
    }

    @Override
    public int deletePersonByPrice(BigDecimal price) {
        Optional<Person> personMaybe = selectPersonByPrice(price);
        if (personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonByPrice(BigDecimal price, Person update) {
        return selectPersonByPrice(price)         //select the person
                .map(person -> {                 //map the person
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0){                //if the index of that person is >=0 we know that we have found that person
                        DB.set(indexOfPersonToUpdate, new Person(price, update.getName()));      //set contents of that person to the new person that we just recieved from thc client
                        return 1;                               //return 1 if everything is fine
                    }
                    return 0;               //otherwise we return 0 or if selectpersonbyprice is not present we dont do anyhthing and just return 0
                })
                .orElse(0);
    }
}
