package iv1201.group1.applications.recruitment.model;

import org.springframework.data.jpa.repository.JpaRepository;
import iv1201.group1.applications.recruitment.domain.Person;

public interface UserJpaRepository extends JpaRepository<Person,Long>{
    Person findByUsername(String username);
}
