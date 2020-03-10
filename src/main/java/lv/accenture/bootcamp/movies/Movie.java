package lv.accenture.bootcamp.movies;

import java.util.*;

public class Movie implements Comparable<Movie> {

    private String id;
    private String name;
    private Float rating;
    private String description;
    private List<String> cast;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCast() {
        return cast;
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
        return  Objects.equals(getName(), movie.getName()) &&
                Objects.equals(getRating(), movie.getRating()) &&
                Objects.equals(getDescription(), movie.getDescription()) &&
                Objects.equals(getCast(), movie.getCast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRating(), getDescription(), getCast());
    }

    @Override
    public int compareTo(Movie movie) {
        int result = name.compareToIgnoreCase(movie.getName());
        if (result != 0) return result;
        result = rating.compareTo(movie.getRating());
        if (result != 0) return result;
        result = description.compareToIgnoreCase(movie.getDescription());
        if (result != 0) return result;

        List<String> cast1 = new ArrayList<>(cast);
        List<String> cast2 = new ArrayList<>(movie.getCast());
        Collections.sort(cast1);
        Collections.sort(cast2);
        for (int i = 0; i < cast1.size() && i < cast2.size(); i++) {
            result = cast1.get(i).compareToIgnoreCase(cast2.get(i));
            if (result != 0) return result;
        }
        return result;
        // result = id.compareTo(movie.getId());
        // return result;
    }

}
