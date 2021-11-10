package nl.novi.end.project.application.respository;

import nl.novi.end.project.application.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
