package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import iv1201.group1.applications.recruitment.exceptionhandling.validation.ValidEmail;

import java.util.List;
import java.util.Objects;

/**
 * A object person that is mapped to the table with the same name in the database.
 */
@Entity
@Table(name = "person")
public class Person {
   private Integer personId;
   @NotBlank(message="Name is required")
   private String name;
   @NotBlank(message="Surname is required")
   private String surname;
   @NotBlank(message="Social security number is required")
   private String ssn;
   @NotBlank(message="Email is required")
   @ValidEmail
   private String email;
   @NotBlank(message="Password is required")
   private String password;
   @NotBlank(message="Username is required")
   private String username;
   private Role role;
   private List<Availability> availabilityList;
   private List<CompetenceProfile> competenceProfileList;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_person_id_seq_generator")
   @SequenceGenerator(name = "person_person_id_seq_generator", sequenceName = "person_person_id_seq", allocationSize = 1, initialValue = 4)
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

   /**
    * A function for comparing this object with a object o.
    * @param o
    * @return returns true/false.
    */
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

   /**
    * A function for hashing the object.
    * @return returns the hash of the object.
    */
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

   @OneToMany(mappedBy = "person")
   public List<Availability> getAvailabilityList() {
      return availabilityList;
   }

   public void setAvailabilityList(List<Availability> availabilityByPersonId) {
      this.availabilityList = availabilityByPersonId;
   }

   @OneToMany(mappedBy = "person")
   public List<CompetenceProfile> getCompetenceProfileList() {
      return competenceProfileList;
   }

   public void setCompetenceProfileList(List<CompetenceProfile> competenceProfileByPersonId) {
      this.competenceProfileList = competenceProfileByPersonId;
   }
}
