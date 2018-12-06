package DAL.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "box_with_game", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class BoxWithGameEntity {
    private int id;
    private String title;
    private Integer condition;
    private Date dateOfPurchase;
    private Integer anticafeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Basic
    @Column(name = "anticafe_id", nullable = true)
    public Integer getAnticafeId() {
        return anticafeId;
    }

    public void setAnticafeId(Integer anticafeId) {
        this.anticafeId = anticafeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxWithGameEntity that = (BoxWithGameEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(dateOfPurchase, that.dateOfPurchase) &&
                Objects.equals(anticafeId, that.anticafeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, condition, dateOfPurchase, anticafeId);
    }
}
