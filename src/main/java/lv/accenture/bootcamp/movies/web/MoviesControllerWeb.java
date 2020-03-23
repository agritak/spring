package lv.accenture.bootcamp.movies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Controller
public class MoviesControllerWeb {
    @Autowired
    private MoviesService movies;

    @RequestMapping("/myMovies")
    public String listMovies(Model model) {
        model.addAttribute("movies", movies.sort(Sorting.RATING));
        return "movies";
    }

    @GetMapping("/addMovie")
    public String showForm(Movie movie) {
        return "addMovie";
    }

    @PostMapping("/addMovie")
    @ResponseStatus(HttpStatus.CREATED)
    public String processForm(@Valid Movie movie, Errors errors) {
        if (errors.hasErrors()) {
            return "addMovie";
        }
        if (movies.create(movie) == null) {
            return "exists";
        }
        return "result";
    }
}
