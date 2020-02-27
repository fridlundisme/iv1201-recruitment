package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "competence_profile")
public class CompetenceProfile {
   private Integer competenceProfileId;
   private Integer yearsOfExperience;
   private Person person;
   private Competence competence;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "competence_profile_id", nullable = false)
   public Integer getCompetenceProfileId() {
      return competenceProfileId;
   }

   public void setCompetenceProfileId(Integer competenceProfileId) {
      this.competenceProfileId = competenceProfileId;
   }

   @Basic
   @Column(name = "years_of_experience", nullable = false)
   public Integer getYearsOfExperience() {
      return yearsOfExperience;
   }

   public void setYearsOfExperience(Integer yearsOfExperience) {
      this.yearsOfExperience = yearsOfExperience;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      CompetenceProfile that = (CompetenceProfile) o;
      return Objects.equals(competenceProfileId, that.competenceProfileId) &&
              Objects.equals(yearsOfExperience, that.yearsOfExperience);
   }

   @Override
   public int hashCode() {
      return Objects.hash(competenceProfileId, yearsOfExperience);
   }

   @ManyToOne
   @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
   public Person getPerson() {
      return person;
   }

   public void setPerson(Person personByPersonId) {
      this.person = personByPersonId;
   }

   @ManyToOne
   @JoinColumn(name = "competence_id", referencedColumnName = "competence_id", nullable = false)
   public Competence getCompetence() {
      return competence;
   }

   public void setCompetence(Competence competenceByCompetenceId) {
      this.competence = competenceByCompetenceId;
   }
}
