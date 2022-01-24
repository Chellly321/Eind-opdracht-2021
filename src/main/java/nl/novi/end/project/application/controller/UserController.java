package nl.novi.end.project.application.controller;

import nl.novi.end.project.application.respository.UserRepository;
import nl.novi.end.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.novi.end.project.application.model.User;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //attributen
    private List <User> users = new ArrayList<>();

    //getters and setters

    public void setPersons(List<User> users) {
        this.users = users;
    }

    //constructor
    public UserController() {
        User user1 = new User();
        user1.setUserName("Michelle");
        user1.setAge("24");
        user1.setEmail("michelle.royer@icloud.com");
        user1.setGender("Female");
        users.add(user1);

        User user2 = new User();
        user2.setUserName("Elena");
        user2.setAge("23");
        user2.setEmail("elena.gramlich@yahoo.de");
        user2.setGender("Female");
        users.add(user2);
    }
    @Autowired
    private UserRepository userRepository;

@GetMapping(value = "/persons")
public ResponseEntity<Object>getPersons(){
    return ResponseEntity.ok(userRepository.findAll());
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
    public ResponseEntity<Object> addPerson(@RequestBody User user){
    userService.createUser(user);
    return ResponseEntity.created(null).build();
}

@PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> addPerson(@PathVariable("id")int id,@RequestBody User user){
    users.set(id, user);
    return ResponseEntity.created(null).build();
    }

}

