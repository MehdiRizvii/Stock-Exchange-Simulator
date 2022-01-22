package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }


    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
@GetMapping
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonByPrice(BigDecimal price){
        return personDao.selectPersonByPrice(price);
    }
    public int deletePerson(BigDecimal price){
        return personDao.deletePersonByPrice(price);
    }
    public int updatePerson(BigDecimal price, Person newPerson){
        return personDao.updatePersonByPrice(price, newPerson);
    }

}
