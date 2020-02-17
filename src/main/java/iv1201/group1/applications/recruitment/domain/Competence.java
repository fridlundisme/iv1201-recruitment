package iv1201.group1.applications.recruitment.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "competence")
public class Competence implements Serializable{

    public Competence(){}
    @Id
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