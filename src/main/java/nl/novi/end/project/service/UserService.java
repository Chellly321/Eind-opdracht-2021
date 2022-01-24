package nl.novi.end.project.service;

import nl.novi.end.project.application.model.Role;
import nl.novi.end.project.application.model.User;
import nl.novi.end.project.application.respository.UserRepository;
import nl.novi.end.project.dto.UserRequestDto;
import nl.novi.end.project.exceptions.BadRequestException;
import nl.novi.end.project.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    private String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetails) authentication.getPrincipal()).getUsername();
    }

    public Iterable<User> getUsers() {
        return  userRepository.findAll();
    }



    public void createUser(User userPostRequest) {




            userPostRequest.setPassword(passwordEncoder.encode(userPostRequest.getPassword()));


            Role role = new Role();
            role.setId(1);
            role.setName("USER");

            Set<Role> roles = new HashSet<>();
            roles.add(role);
            userPostRequest.setRoles(roles);
            userRepository.save(userPostRequest);

    }
    /*public void addAuthority(String username, String authorityString){
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()){
            throw new UserNotFoundException(username);
        } else {
            User user = userOptional.get();
            user.addAuthority(authorityString);
            userRepository.save(user);
        }
    }*/
}
