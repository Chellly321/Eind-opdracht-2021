package nl.novi.end.project.application.controller;

import nl.novi.end.project.application.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.novi.end.project.application.model.Person;

import javax.management.ValueExp;
import java.util.ArrayList;
import java.util.List;


@RestController
public class PersonController {

    //attributen
    private List <Person> persons = new ArrayList<>();

    //getters and setters

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    //constructor
    public PersonController() {
        Person person1 = new Person();
        person1.setName("Michelle");
        person1.setAge("24");
        person1.setEmailaddress("michelle.royer@icloud.com");
        person1.setGender("Female");
        persons.add(person1);

        Person person2 = new Person();
        person2.setName("Elena");
        person2.setAge("23");
        person2.setEmailaddress("elena.gramlich@yahoo.de");
        person2.setGender("Female");
        persons.add(person2);
    }
    @Autowired
    private PersonRepository personRepository;

@GetMapping(value = "/persons")
public ResponseEntity<Object>getPersons(){
    return ResponseEntity.ok(personRepository.findAll());
}
@GetMapping(value = "/persons/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable int id){
    return ResponseEntity.noContent().build();
}

@DeleteMapping(value = "persons/{id}")
public ResponseEntity<Object> deletePerson(@PathVariable int id){
    return ResponseEntity.noContent().build();
}

@PostMapping(value = "/persons")
    public ResponseEntity<Object> addPerson(@RequestBody Person person){
    persons.add(person);
    return ResponseEntity.created(null).build();
}

@PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> addPerson(@PathVariable("id")int id,@RequestBody Person person){
    persons.set(id,person);
    return ResponseEntity.created(null).build();
    }

}

