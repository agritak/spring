package lv.accenture.bootcamp.movies.web;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private String id;
    @NotNull
    @Size(min = 1, message = "The title is necessary.")
    @Column(name = "title", nullable = false)
    private String name;
    @NotNull(message = "Rating is necessary.")
    private Short rating;
    @Column(name = "plot")
    @Size(max = 200, message = ("The maximum length of the description is 200 symbols."))
    private String description;
    private String link;
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

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
