package DAL.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "current_customers", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class CurrentCustomersEntity {
    private Integer cardNumber;
    private Integer idAnticafe;

    @Id
    @Column(name = "card_number", nullable = true)
    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "id_anticafe", nullable = true)
    public Integer getIdAnticafe() {
        return idAnticafe;
    }

    public void setIdAnticafe(Integer idAnticafe) {
        this.idAnticafe = idAnticafe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCustomersEntity that = (CurrentCustomersEntity) o;
        return Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(idAnticafe, that.idAnticafe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, idAnticafe);
    }
}
