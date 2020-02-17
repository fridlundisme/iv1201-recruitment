package iv1201.group1.applications.recruitment.domain;

import java.io.Serializable;

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
    private Long person_id;
    @NotEmpty
    private Long competence_id;
    @NotEmpty
    private Float years_of_experience;

    public Long getCompetence_profile_id() {
        return competence_profile_id;
    }

    public void setCompetence_profile_id(Long competence_profile_id) {
        this.competence_profile_id = competence_profile_id;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public Long getCompetence_id() {
        return competence_id;
    }

    public void setCompetence_id(Long competence_id) {
        this.competence_id = competence_id;
    }

    public Float getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(Float years_of_experience) {
        this.years_of_experience = years_of_experience;
    }


}