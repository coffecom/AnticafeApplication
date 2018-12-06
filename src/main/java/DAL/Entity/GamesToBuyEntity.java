package DAL.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "games_to_buy", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class GamesToBuyEntity {
    private String title;
    private String reason;

    @Id
    @Column(name = "title", nullable = true, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Reason", nullable = false, length = 17)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesToBuyEntity that = (GamesToBuyEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, reason);
    }
}
