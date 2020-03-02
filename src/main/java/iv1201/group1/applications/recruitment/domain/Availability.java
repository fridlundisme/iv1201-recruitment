package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "availability")
public class Availability {
   private Integer availabilityId;
   private Date fromDate;
   private Date toDate;
   private Person person;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "availability_availability_id_seq_generator")
   @SequenceGenerator(name = "availability_availability_id_seq_generator", sequenceName = "availability_availability_id_seq", allocationSize = 1)
   @Column(name = "availability_id", nullable = false)
   public Integer getAvailabilityId() {
      return availabilityId;
   }

   public void setAvailabilityId(Integer availabilityId) {
      this.availabilityId = availabilityId;
   }

   @Basic
   @Column(name = "from_date", nullable = false)
   public Date getFromDate() {
      return fromDate;
   }

   public void setFromDate(Date fromDate) {
      this.fromDate = fromDate;
   }

   @Basic
   @Column(name = "to_date", nullable = false)
   public Date getToDate() {
      return toDate;
   }

   public void setToDate(Date toDate) {
      this.toDate = toDate;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Availability that = (Availability) o;
      return Objects.equals(availabilityId, that.availabilityId) &&
              Objects.equals(fromDate, that.fromDate) &&
              Objects.equals(toDate, that.toDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(availabilityId, fromDate, toDate);
   }

   @ManyToOne
   @JoinColumn(name = "person_id", referencedColumnName = "person_id")
   public Person getPerson() {
      return person;
   }

   public void setPerson(Person personByPersonId) {
      this.person = personByPersonId;
   }

   public void setDates(Date fromDate, Date toDate){
      this.fromDate = fromDate;
      this.toDate = toDate;
   }
}
