package lv.accenture.bootcamp.movies.thymeleaf;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, String> {
    List<Movie> findByNameContains(String name);

    List<Movie> findByOrderByRatingDesc();
}
