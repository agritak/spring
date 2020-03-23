package lv.accenture.bootcamp.movies.jdbc;

import lv.accenture.bootcamp.movies.respository.Movie;
import lv.accenture.bootcamp.movies.respository.Sorting;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class MoviesController {

    //@Autowired
    private MoviesService movies;

    // /movies?order=NAME
    @GetMapping("/movies")
    public List<Movie> movies(@RequestParam(required = false, defaultValue = "NAME") Sorting order) {
        return movies.sort(order);
    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@RequestBody Movie movie) {
        return movies.create(movie);
    }

    @DeleteMapping("/movies/{id}")
    public boolean delete(@PathVariable String id) {
        return movies.delete(id);
    }

    @PutMapping("/movies/{id}")
    public int update(@PathVariable String id, @RequestBody Movie movie) {
        return movies.update(id, movie);
    }

    // /movies/search?keyword=
    @GetMapping("/movies/search")
    public List<Movie> search(@RequestParam String keyword) {
        return movies.search(keyword);
    }
}
