package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao") //class serves as a repository
public class FakePersonDataAcessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))            //filters through the people and checks our DB to see if that person with that id exists
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)         //select the person
                .map(person -> {                 //map the person
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0){                //if the index of that person is >=0 we know that we have found that person
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));      //set contents of that person to the new person that we just recieved from thc client
                        return 1;                               //return 1 if everything is fine
                    }
                    return 0;               //otherwise we return 0 or if selectpersonbyid is not present we dont do anyhthing and just return 0
                })
                .orElse(0);
    }
}
