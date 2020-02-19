package iv1201.group1.applications.recruitment.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import iv1201.group1.applications.recruitment.model.annotations.PasswordMatches;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long person_id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Surname is required")
    private String surname;
    @NotBlank(message = "Social security number is required")
    private String ssn;
    @NotBlank(message = "Enter email")
    private String email;
    @NotBlank(message = "Enter password")
    private String password;
    private Long role_id;
    @NotBlank(message = "Username is required")
    private String username;
    @Transient
    private String retypeEmail;
    @Transient
    private String matchingPassword;

    public Users() { }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long id) {
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

    public String getSsn(){
        return ssn;
    }

    public void setSsn(String ssn){
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

    public String getRetypeEmail() {
        return retypeEmail;
    }

    public void setRetypeEmail(String retypeEmail) {
        this.retypeEmail = retypeEmail;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String retypePassword) {
        this.matchingPassword = retypePassword;
    }

}
