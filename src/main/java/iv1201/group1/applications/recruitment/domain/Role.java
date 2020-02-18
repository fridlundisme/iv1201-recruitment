package iv1201.group1.applications.recruitment.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "role")
public class Role implements Serializable{
   private static final long serialVersionUID = 1L;
    
	@Id
   @Column(columnDefinition = "serial")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long role_id;
	@NotEmpty
   private String name;

   public Role() { }

	public Long getRole_id() {
	   return role_id;
	}

	public void setRole_id(Long id) {
	   this.role_id = id;
	}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }
}
