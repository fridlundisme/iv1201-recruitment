package iv1201.group1.applications.recruitment.model;

import org.springframework.data.jpa.repository.JpaRepository;

import iv1201.group1.applications.recruitment.domain.Competence;

import java.util.List;

public interface CompetenceJpaRepository extends JpaRepository<Competence,Long>{
   List<Competence> findAll();

   Competence findByName(String name);
}