package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "competence", schema = "webapplication", catalog = "d8c0h1d8h1n2en")
public class Competence {
   private Integer competenceId;
   private String name;
   private Collection<CompetenceProfile> competenceProfileList;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
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
