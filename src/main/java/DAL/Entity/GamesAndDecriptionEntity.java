package DAL.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "games_and_decription", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class GamesAndDecriptionEntity {
    private String title;
    private String notation;

    @Id
    @Column(name = "title", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "notation", nullable = true, length = 500)
    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesAndDecriptionEntity that = (GamesAndDecriptionEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(notation, that.notation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, notation);
    }
}
