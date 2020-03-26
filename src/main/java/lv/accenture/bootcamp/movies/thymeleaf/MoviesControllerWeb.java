package lv.accenture.bootcamp.movies.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MoviesControllerWeb {
    private final MovieRepository movieRepository;

    @Autowired
    public MoviesControllerWeb(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("movies", movieRepository.findByOrderByRatingDesc());
        return "movies";
    }

    @GetMapping("/form")
    public String showForm(Movie movie) {
        return "add-movie";
    }

    @PostMapping("/addmovie")
    public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-movie";
        }

        boolean exists = false;

        for (Movie m : movieRepository.findAll()) {
            if (m.equals(movie)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            movieRepository.save(movie);
        }

        model.addAttribute("movies", movieRepository.findByOrderByRatingDesc());
        return "redirect:#list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id: " + id));
        model.addAttribute("movie", movie);
        return "update-movie";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") String id,
                              @Valid Movie movie,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            return "update-movie";
        }
        movieRepository.save(movie);
        model.addAttribute("movies", movieRepository.findByOrderByRatingDesc());
        return "movies";
    }

    @GetMapping("delete/{id}")
    public String deleteMovie(@PathVariable("id") String id, Model model) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        movieRepository.delete(movie);
        model.addAttribute("movies", movieRepository.findByOrderByRatingDesc());
        return "movies";
    }

}
