package iv1201.group1.applications.recruitment.model;

import iv1201.group1.applications.recruitment.domain.types.AuthorityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJparepository extends JpaRepository<AuthorityType, Long> {
}
