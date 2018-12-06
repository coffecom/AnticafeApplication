package DAL.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "top10_games", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class Top10GamesEntity {
    private String title;
    private String popularity;
    private String genre;
    private Integer age;
    private Integer difficulty;
    private String notation;

    @Id
    @Column(name = "Title", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Popularity", nullable = true, length = 50)
    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    @Basic
    @Column(name = "Genre", nullable = true, length = 20)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "Age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "Difficulty", nullable = true)
    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    @Basic
    @Column(name = "Notation", nullable = true, length = 500)
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
        Top10GamesEntity that = (Top10GamesEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(popularity, that.popularity) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(age, that.age) &&
                Objects.equals(difficulty, that.difficulty) &&
                Objects.equals(notation, that.notation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, popularity, genre, age, difficulty, notation);
    }
}
