package iv1201.group1.applications.recruitment.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "competence")
public class Competence implements Serializable{

    public Competence(){}
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long competence_id;
    @NotEmpty
    private String name;

    public Long getCompetence_id() {
        return competence_id;
    }

    public void setCompetence_id(Long competence_id) {
        this.competence_id = competence_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}