package iv1201.group1.applications.recruitment.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


/**
 * A object availability that is mapped to the table with the same name in the database.
 */
@Entity
@Table(name = "availability")
public class Availability {
   private Integer availabilityId;
   private Date fromDate;
   private Date toDate;
   private Person person;

   /**
    * Returns a availability id.
    * @return availability id.
    */
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "availability_availability_id_seq_generator")
   @SequenceGenerator(name = "availability_availability_id_seq_generator", sequenceName = "availability_availability_id_seq", allocationSize = 1, initialValue = 4)
   @Column(name = "availability_id", nullable = false)
   public Integer getAvailabilityId() {
      return availabilityId;
   }

   /**
    * Sets the id for availability.
    * @param availabilityId is an integer
    */
   public void setAvailabilityId(Integer availabilityId) {
      this.availabilityId = availabilityId;
   }

   /**
    * A function for getting the first date of the availability period.
    * @return a date which the availability starts from.
    */
   @Basic
   @Column(name = "from_date", nullable = false)
   public Date getFromDate() {
      return fromDate;
   }

   /**
    * A function for setting the first date of a availability period.
    * @param fromDate is in the form date.
    */
   public void setFromDate(Date fromDate) {
      this.fromDate = fromDate;
   }

   /**
    * A function for getting the last date of a availability period.
    * @return returns a date.
    */
   @Basic
   @Column(name = "to_date", nullable = false)
   public Date getToDate() {
      return toDate;
   }

   /**
    * A function for setting the last date of a availability period.
    * @param toDate is in the form date.
    */
   public void setToDate(Date toDate) {
      this.toDate = toDate;
   }

   /**
    * A function for checking if the availability object
    * @param o is the same as this object.
    * @return returns a boolean that answers if they are the same or not.
    */
   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Availability that = (Availability) o;
      return Objects.equals(availabilityId, that.availabilityId) &&
              Objects.equals(fromDate, that.fromDate) &&
              Objects.equals(toDate, that.toDate);
   }

   /**
    * Hashes the availability object.
    * @return a hash of the object.
    */
   @Override
   public int hashCode() {
      return Objects.hash(availabilityId, fromDate, toDate);
   }

   /**
    * A function for getting the person which has the availability.
    * @return returns a person.
    */
   @ManyToOne
   @JoinColumn(name = "person_id", referencedColumnName = "person_id")
   public Person getPerson() {
      return person;
   }

   /**
    * A function for setting the person whom shall have the availability.
    * @param personByPersonId
    */
   public void setPerson(Person personByPersonId) {
      this.person = personByPersonId;
   }
}
