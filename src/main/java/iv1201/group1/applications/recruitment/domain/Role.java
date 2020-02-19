package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "webapplication", catalog = "d8c0h1d8h1n2en")
public class Role {
   private Integer roleId;
   private String name;
   private List<Person> peopleList;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Role that = (Role) o;
      return Objects.equals(roleId, that.roleId) &&
              Objects.equals(name, that.name);
   }

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
