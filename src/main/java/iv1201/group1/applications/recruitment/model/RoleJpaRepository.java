package iv1201.group1.applications.recruitment.model;

import iv1201.group1.applications.recruitment.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<Role,Long> {
   Role findByName(String name);
}
