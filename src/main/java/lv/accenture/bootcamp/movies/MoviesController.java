package lv.accenture.bootcamp.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.xml.ws.Response;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class MoviesController {

    @Autowired private MoviesService movies;

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
    public void delete(@PathVariable String id) {
        movies.delete(id);
    }

    @PutMapping("/movies/{id}")
    public void update(@PathVariable String id, @RequestBody Movie movie) {
        movies.update(id, movie);
    }

    @GetMapping("/movies/search/{keyword}")
    public Map<String, Movie> search(@PathVariable String keyword) {
        return movies.search(keyword);
    }
}
