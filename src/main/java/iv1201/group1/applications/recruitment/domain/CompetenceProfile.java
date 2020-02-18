package iv1201.group1.applications.recruitment.domain;

import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "competence_profile")
public class CompetenceProfile implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long competence_profile_id;
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private List<Person> persons;
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Competence.class)
    @JoinColumn(name = "competence_id", insertable = false, updatable = false)
    private Competence competence;
    @NotEmpty
    private Float years_of_experience;

    public Long getCompetence_profile_id() {
        return competence_profile_id;
    }

    public void setCompetence_profile_id(Long competence_profile_id) {
        this.competence_profile_id = competence_profile_id;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> plist) {
        this.persons = plist;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence comp) {
        this.competence = comp;
    }

    public Float getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(Float years_of_experience) {
        this.years_of_experience = years_of_experience;
    }


}