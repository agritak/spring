package lv.accenture.bootcamp.movies.respository;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public enum Sorting {

    NAME(comparing(Movie::getName)),
    RATING(comparing(Movie::getRating).reversed());

    private Comparator<Movie> comparator;

    Sorting(Comparator<Movie> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Movie> getComparator() {
        return comparator;
    }

}
