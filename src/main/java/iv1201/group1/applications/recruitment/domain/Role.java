package iv1201.group1.applications.recruitment.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "role")
public class Role implements Serializable{
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
	@Id
   @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
