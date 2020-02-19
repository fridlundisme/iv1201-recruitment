package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "person", schema = "webapplication")
public class Person {
   private Integer personId;
   @NotBlank(message="Name is required")
   private String name;
   @NotBlank(message="Surname is required")
   private String surname;
   @NotBlank(message="Social security number is required")
   private String ssn;
   @NotBlank(message="Email is required")
   private String email;
   @NotBlank(message="Password is required")
   private String password;
   @NotBlank(message="Username is required")
   private String username;
   private Role role;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "person_id", nullable = false)
   public Integer getPersonId() {
      return personId;
   }

   public void setPersonId(Integer personId) {
      this.personId = personId;
   }

   @Basic
   @Column(name = "name", nullable = false, length = -1)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Basic
   @Column(name = "surname", nullable = false, length = -1)
   public String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   @Basic
   @Column(name = "ssn", nullable = false, length = -1)
   public String getSsn() {
      return ssn;
   }

   public void setSsn(String ssn) {
      this.ssn = ssn;
   }

   @Basic
   @Column(name = "email", nullable = false, length = -1)
   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Basic
   @Column(name = "password", nullable = false, length = -1)
   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Basic
   @Column(name = "username", nullable = false, length = -1)
   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Person that = (Person) o;
      return Objects.equals(personId, that.personId) &&
              Objects.equals(name, that.name) &&
              Objects.equals(surname, that.surname) &&
              Objects.equals(ssn, that.ssn) &&
              Objects.equals(email, that.email) &&
              Objects.equals(password, that.password) &&
              Objects.equals(username, that.username);
   }

   @Override
   public int hashCode() {
      return Objects.hash(personId, name, surname, ssn, email, password, username);
   }

   @ManyToOne
   @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
   public Role getRole() {
      return role;
   }

   public void setRole(Role roleByRoleId) {
      this.role = roleByRoleId;
   }
}
