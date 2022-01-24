package nl.novi.end.project.service;

import nl.novi.end.project.application.model.Role;
import nl.novi.end.project.application.respository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("roleService")
public class RoleService {
    @Autowired
    RoleRepository roleRepository;



    public Optional<Role> findByRoleId(int id){

        return roleRepository.findById(id);
    }


    public Role save(Role role) {

        Optional<Role> roleDbOptional = roleRepository.findById(role.getId());
        if (roleDbOptional.isPresent()) {
            return role;
        } else {
            return roleRepository.save(role);
        }
    }
}
