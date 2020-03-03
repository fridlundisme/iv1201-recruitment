package iv1201.group1.applications.recruitment.model;

import iv1201.group1.applications.recruitment.domain.CompetenceProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceProfileJpaRepository extends JpaRepository<CompetenceProfile,Long> {
}
