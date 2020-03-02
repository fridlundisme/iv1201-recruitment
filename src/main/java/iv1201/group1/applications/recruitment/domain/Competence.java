package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * A object competence that is mapped to the table in the database with the same name.
 */
@Entity
@Table(name = "competence")
public class Competence {
   private Integer competenceId;
   private String name;
   private Collection<CompetenceProfile> competenceProfileList;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competence_competence_id_seq_generator")
   @SequenceGenerator(name = "competence_competence_id_seq_generator", sequenceName = "competence_competence_id_seq", allocationSize = 1, initialValue = 4)
   @Column(name = "competence_id", nullable = false)
   public Integer getCompetenceId() {
      return competenceId;
   }

   public void setCompetenceId(Integer competenceId) {
      this.competenceId = competenceId;
   }

   @Basic
   @Column(name = "name", nullable = false, length = -1)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   /**
    * Compares the competence object o with this competence object.
    * @param o is a competence object.
    * @return returns a boolean that says if the objects are equal or not.
    */
   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Competence that = (Competence) o;
      return Objects.equals(competenceId, that.competenceId) &&
              Objects.equals(name, that.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(competenceId, name);
   }

   @OneToMany(mappedBy = "competence")
   public Collection<CompetenceProfile> getCompetenceProfileList() {
      return competenceProfileList;
   }

   public void setCompetenceProfileList(Collection<CompetenceProfile> competenceProfilesByCompetenceId) {
      this.competenceProfileList = competenceProfilesByCompetenceId;
   }
}
