package lv.accenture.bootcamp.movies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MoviesService {

    @Autowired
    private MovieRepository repository;

    public Iterable<Movie> movies() {
        return repository.findAll();
    }

    public Movie create(Movie movie) {
        for (Movie m : movies()) {
            if (m.equals(movie)) {
                return null;
            }
        }
        movie.setId(UUID.randomUUID().toString());
        return repository.save(movie);
    }


    public void update(String id, Movie movie) {
        Optional<Movie> optional = repository.findById(id);
        if (optional.isPresent()) {
            Movie m = optional.get();
            m.setName(movie.getName());
            m.setRating(movie.getRating());
            m.setDescription(movie.getDescription());
            repository.save(m);
        }
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Iterable<Movie> sort(Sorting order) {
        //Iterable<Movie> sort = repository.findAll(Sort.by("name"));
        Iterable<Movie> iterable = movies();
        List<Movie> movies = new ArrayList<>();
        iterable.forEach(movies::add);
        movies.sort(order.getComparator());
        return movies;
    }

    public Iterable<Movie> search(String keyword) {
        return repository.findByNameContains(keyword);
    }
}
