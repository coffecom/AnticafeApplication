package DAL;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "current_customers", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class EntityCurrentCustomers implements Serializable {
    private EntityAnticafe anticafeByIdAnticafe;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_anticafe", referencedColumnName = "id")
    public EntityAnticafe getAnticafeByIdAnticafe() {
        return anticafeByIdAnticafe;
    }

    public void setAnticafeByIdAnticafe(EntityAnticafe anticafeByIdAnticafe) {
        this.anticafeByIdAnticafe = anticafeByIdAnticafe;
    }
}
