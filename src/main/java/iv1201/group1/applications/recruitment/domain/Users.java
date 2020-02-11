package iv1201.group1.applications.recruitment.domain;

import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer person_id;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String name;
    private String surname;
    private String ssn;
    private String email;
    private String password;
    @NotEmpty
    private Long role_id;
    private String username;

    public Users() { }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer id) {
        this.person_id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSSN(){
        return ssn;
    }

    public void setSSN(String ssn){
        this.ssn = ssn;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRole_id(){
        return this.role_id;
    }

    public void setRole_id(long role_id){
        this.role_id = role_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
