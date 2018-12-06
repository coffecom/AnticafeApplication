package DAL.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "current_cusomers_and_games", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class CurrentCusomersAndGamesEntity {
    private Integer customerId;
    private String customerName;
    private String gameTitle;
    private Integer gameId;
    private Integer idAnticafe;
    private Integer timeInCafe;

    @Id
    @Column(name = "Customer_id", nullable = true)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "Customer_name", nullable = true, length = 50)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "Game_title", nullable = true, length = 30)
    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    @Basic
    @Column(name = "Game_id", nullable = true)
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "id_anticafe", nullable = true)
    public Integer getIdAnticafe() {
        return idAnticafe;
    }

    public void setIdAnticafe(Integer idAnticafe) {
        this.idAnticafe = idAnticafe;
    }

    @Basic
    @Column(name = "Time_in_cafe", nullable = true)
    public Integer getTimeInCafe() {
        return timeInCafe;
    }

    public void setTimeInCafe(Integer timeInCafe) {
        this.timeInCafe = timeInCafe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCusomersAndGamesEntity that = (CurrentCusomersAndGamesEntity) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(gameTitle, that.gameTitle) &&
                Objects.equals(gameId, that.gameId) &&
                Objects.equals(idAnticafe, that.idAnticafe) &&
                Objects.equals(timeInCafe, that.timeInCafe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, gameTitle, gameId, idAnticafe, timeInCafe);
    }
}
