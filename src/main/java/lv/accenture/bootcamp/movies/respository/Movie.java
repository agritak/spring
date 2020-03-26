package lv.accenture.bootcamp.movies.respository;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import java.util.List;
import java.util.Objects;

//@Entity
//@Table(name = "movies")
public class Movie {

    @Id
    private String id;
    @Column(name = "title", nullable = false)
    private String name;
    private Float rating;
    @Column(name = "plot")
    private String description;
    @Transient
    private List<String> cast;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getName(), movie.getName()) &&
                Objects.equals(getRating(), movie.getRating()) &&
                Objects.equals(getDescription(), movie.getDescription());
        //&& Objects.equals(getId(), movie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRating(), getDescription());
    }
}
