import nl.novi.end.project.application.model.Role;
import nl.novi.end.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }


    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("USER");
        roleService.save(role1);

        Role role2 = new Role();
        role2.setId(2);
        role2.setName("ADMIN");
        roleService.save(role2);


    }
}
