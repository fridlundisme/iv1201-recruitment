package iv1201.group1.applications.recruitment.model;

import org.springframework.data.jpa.repository.JpaRepository;

import iv1201.group1.applications.recruitment.domain.Competence;

public interface CompetenceJpaRepository extends JpaRepository<Competence,Long>{}