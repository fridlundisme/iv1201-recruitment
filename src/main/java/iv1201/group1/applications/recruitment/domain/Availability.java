package iv1201.group1.applications.recruitment.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "availability")
public class Availability implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Integer availability_id;
    private Integer person_id;
    @NotEmpty
    private LocalDateTime from_date;
    @NotEmpty
    private LocalDateTime to_date;

    public Integer getAvailability_id(){
        return this.availability_id;
    }

    public void setAvailability_id(Integer i){
        this.availability_id = i;
    }

    public Integer getPerson_id(){
        return this.person_id;
    }

    public void setPerson_id(Integer i){
        this.person_id = i;
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