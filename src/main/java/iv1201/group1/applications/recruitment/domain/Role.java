package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * A object role that is mapped to the table with the same name in the database.
 */
@Entity
@Table(name = "role")
public class Role {
   private Integer roleId;
   private String name;
   private List<Person> peopleList;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_role_id_seq_generator")
   @SequenceGenerator(name = "role_role_id_seq_generator", sequenceName = "role_role_id_seq", allocationSize = 1, initialValue = 4)
   @Column(name = "role_id", nullable = false)
   public Integer getRoleId() {
      return roleId;
   }

   public void setRoleId(Integer roleId) {
      this.roleId = roleId;
   }

   @Basic
   @Column(name = "name", nullable = false, length = -1)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   /**
    * A function for comparing this object with an object o.
    * @param o an object that is to be compared.
    * @return a boolean value true/false.
    */
   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Role that = (Role) o;
      return Objects.equals(roleId, that.roleId) &&
              Objects.equals(name, that.name);
   }

   /**
    * Function that hash the object.
    * @return returns the hash of the object.
    */
   @Override
   public int hashCode() {
      return Objects.hash(roleId, name);
   }

   @OneToMany(mappedBy = "role")
   public List<Person> getPeopleList() {
      return peopleList;
   }

   public void setPeopleList(List<Person> peopleByRoleId) {
      this.peopleList = peopleByRoleId;
   }
}
