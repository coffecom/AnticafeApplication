package DAL.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "game", schema = "dbo", catalog = "anticafeM3205Gudauskayte")
public class EntityGame {
    private String title;
    private String genre;
    private Integer recomendedAge;
    private Integer difficulty;
    private String popularity;
    private String notation;
    private Integer costOfMinute;
    private Integer minutesPlayed;
    private Integer quantityOfBoxes;

    @Id
    @Column(name = "title", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "genre", nullable = true, length = 20)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "recomended_age", nullable = true)
    public Integer getRecomendedAge() {
        return recomendedAge;
    }

    public void setRecomendedAge(Integer recomendedAge) {
        this.recomendedAge = recomendedAge;
    }

    @Basic
    @Column(name = "difficulty", nullable = true)
    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    @Basic
    @Column(name = "popularity", nullable = true, length = 50)
    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    @Basic
    @Column(name = "notation", nullable = true, length = 500)
    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    @Basic
    @Column(name = "cost_of_minute", nullable = true)
    public Integer getCostOfMinute() {
        return costOfMinute;
    }

    public void setCostOfMinute(Integer costOfMinute) {
        this.costOfMinute = costOfMinute;
    }

    @Basic
    @Column(name = "minutes_played", nullable = true)
    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    @Basic
    @Column(name = "quantity_of_boxes", nullable = true)
    public Integer getQuantityOfBoxes() {
        return quantityOfBoxes;
    }

    public void setQuantityOfBoxes(Integer quantityOfBoxes) {
        this.quantityOfBoxes = quantityOfBoxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityGame that = (EntityGame) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(recomendedAge, that.recomendedAge) &&
                Objects.equals(difficulty, that.difficulty) &&
                Objects.equals(popularity, that.popularity) &&
                Objects.equals(notation, that.notation) &&
                Objects.equals(costOfMinute, that.costOfMinute) &&
                Objects.equals(minutesPlayed, that.minutesPlayed) &&
                Objects.equals(quantityOfBoxes, that.quantityOfBoxes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, recomendedAge, difficulty, popularity, notation, costOfMinute, minutesPlayed, quantityOfBoxes);
    }
}
