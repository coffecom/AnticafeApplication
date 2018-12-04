package DAL.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "box_with_game", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class EntityBoxWithGame {
    private int id;
    private Integer condition;
    private Date dateOfPurchase;
    private EntityAnticafe anticafeByAnticafeId;

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
    @Column(name = "condition", nullable = true)
    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "date_of_purchase", nullable = true)
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityBoxWithGame that = (EntityBoxWithGame) o;
        return id == that.id &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(dateOfPurchase, that.dateOfPurchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, condition, dateOfPurchase);
    }

    @ManyToOne
    @JoinColumn(name = "anticafe_id", referencedColumnName = "id")
    public EntityAnticafe getAnticafeByAnticafeId() {
        return anticafeByAnticafeId;
    }

    public void setAnticafeByAnticafeId(EntityAnticafe anticafeByAnticafeId) {
        this.anticafeByAnticafeId = anticafeByAnticafeId;
    }
}
