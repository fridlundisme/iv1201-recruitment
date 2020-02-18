package iv1201.group1.applications.recruitment.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "availability")
public class Availability implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availability_id;
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private List<Person> persons;
    @NotEmpty
    private LocalDateTime from_date;
    @NotEmpty
    private LocalDateTime to_date;

    public Long getAvailability_id(){
        return this.availability_id;
    }

    public void setAvailability_id(Long i) { this.availability_id = i; }

    public List getPersons(){
        return this.persons;
    }

    public void setPersons(List<Person> plist){
        this.persons = plist;
    }

    public LocalDateTime getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDateTime from_date) {
        this.from_date = from_date;
    }

    public LocalDateTime getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDateTime to_date) {
        this.to_date = to_date;
    }

}