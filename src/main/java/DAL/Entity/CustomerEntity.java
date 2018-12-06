package DAL.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class CustomerEntity {
    private int cardNumber;
    private Integer currentTable;
    private Integer currentPayment;
    private Timestamp registrationTime;
    private Integer idOfCurrentGame;

    @Id
    @Column(name = "card_number", nullable = false)
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "current_table", nullable = true)
    public Integer getCurrentTable() {
        return currentTable;
    }

    public void setCurrentTable(Integer currentTable) {
        this.currentTable = currentTable;
    }

    @Basic
    @Column(name = "current_payment", nullable = true)
    public Integer getCurrentPayment() {
        return currentPayment;
    }

    public void setCurrentPayment(Integer currentPayment) {
        this.currentPayment = currentPayment;
    }

    @Basic
    @Column(name = "registration_time", nullable = true)
    public Timestamp getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Basic
    @Column(name = "id_of_current_game", nullable = true)
    public Integer getIdOfCurrentGame() {
        return idOfCurrentGame;
    }

    public void setIdOfCurrentGame(Integer idOfCurrentGame) {
        this.idOfCurrentGame = idOfCurrentGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return cardNumber == that.cardNumber &&
                Objects.equals(currentTable, that.currentTable) &&
                Objects.equals(currentPayment, that.currentPayment) &&
                Objects.equals(registrationTime, that.registrationTime) &&
                Objects.equals(idOfCurrentGame, that.idOfCurrentGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, currentTable, currentPayment, registrationTime, idOfCurrentGame);
    }
}
