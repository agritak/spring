package lv.accenture.bootcamp.movies.map;

import lv.accenture.bootcamp.movies.respository.Movie;
import lv.accenture.bootcamp.movies.respository.Sorting;

import java.util.*;

import static java.util.Arrays.asList;

public class MoviesService {

    private Map<String, Movie> movies = new HashMap<>();

    //@PostConstruct
    public void onStartup() {
        Movie movie = new Movie();
        movie.setId(UUID.randomUUID().toString());
        movie.setName("1917");
        movie.setRating(8.3F);
        movie.setDescription("It's movie about two friends saving comrades.");
        movie.setCast(asList("George MacKay, Benedict Cumberbatch"));

        movies.put(movie.getId(), movie);
    }


    public List<Movie> movies() {
        return new ArrayList<Movie>(movies.values());
    }


    public Movie create(Movie movie) {
        for (Movie m : movies.values()) {
            if (m.equals(movie)) {
                return null;
            }
        }
        movies.put(movie.getId(), movie);
        return movie;
    }


    public void update(String id, Movie movie) {
        if (movies.containsKey(id)) {
            Movie m = movies.get(id);
            m.setName(movie.getName());
            m.setDescription(movie.getDescription());
            m.setCast(movie.getCast());
            m.setRating(movie.getRating());
            movies.replace(id, movies.get(id), m);
        }
    }

    public void delete(String id) {
        movies.remove(id);
    }

    public List<Movie> sort(Sorting order) {
        List<Movie> movies = new ArrayList<>(this.movies.values());
        movies.sort(order.getComparator());
        return movies;
    }

    public Map<String, Movie> search(String keyword) {
        Map<String, Movie> found = new LinkedHashMap<>();
        for (Movie movie : movies.values()) {
            if (movie.getName().toLowerCase().contains(keyword.toLowerCase())) {
                found.put(movie.getId(), movie);
            }
        }
        return found;

//        for (Movie movie : movies.values()) {
//            for (String cast : movie.getCast()) {
//                if (cast.toLowerCase().contains(keyword.toLowerCase())) {
//                    found.put(movie.getId(), movie);
//                }
//            }
//        }
    }

}
