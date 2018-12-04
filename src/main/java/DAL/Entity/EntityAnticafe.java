package DAL.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "anticafe", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class EntityAnticafe {
    private int id;
    private String workingHours;
    private Integer numberOfTables;
    private String addressOfCafe;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "working_hours", nullable = true, length = 20)
    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    @Basic
    @Column(name = "number_of_tables", nullable = true)
    public Integer getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(Integer numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    @Basic
    @Column(name = "address_of_cafe", nullable = true, length = 70)
    public String getAddressOfCafe() {
        return addressOfCafe;
    }

    public void setAddressOfCafe(String addressOfCafe) {
        this.addressOfCafe = addressOfCafe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityAnticafe that = (EntityAnticafe) o;
        return id == that.id &&
                Objects.equals(workingHours, that.workingHours) &&
                Objects.equals(numberOfTables, that.numberOfTables) &&
                Objects.equals(addressOfCafe, that.addressOfCafe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workingHours, numberOfTables, addressOfCafe);
    }
}
