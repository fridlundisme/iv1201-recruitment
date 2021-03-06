package iv1201.group1.applications.recruitment.model;

import org.springframework.data.jpa.repository.JpaRepository;
import iv1201.group1.applications.recruitment.domain.Person;

import java.util.List;

public interface PersonJpaRepository extends JpaRepository<Person,Long>{
    Person findByUsername(String username);

    Person findByEmail(String email);
}
