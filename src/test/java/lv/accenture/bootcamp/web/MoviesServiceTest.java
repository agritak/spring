package lv.accenture.bootcamp.web;

import lv.accenture.bootcamp.movies.web.Movie;
import lv.accenture.bootcamp.movies.web.MovieRepository;
import lv.accenture.bootcamp.movies.web.MoviesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MoviesServiceTest {
    // @Mock šo anotāciju varat izmantot priekš mock objektiem
    // @InjectMocks izmantosiet lai anotētu savu servisu

    @InjectMocks
    private MoviesService moviesService = new MoviesService();
    @Mock
    private MovieRepository movieRepository;

    private List<Movie> movies;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Movie movie1 = new Movie();
        movie1.setName("Movie1");
        Movie movie2 = new Movie();
        movie2.setName("Movie2");

        movies = Arrays.asList(movie1, movie2, new Movie());
        when(movieRepository.findAll()).thenReturn(movies);
    }

    @Test
    public void movies() {
        List<Movie> list = (List<Movie>) moviesService.movies();
        int expected = 3;
        int actual = list.size();
        assertEquals("There should be 3 movies in the list.", expected, actual);
        verify(movieRepository).findAll();
    }

    @Test
    public void createNewMovie() {
        Movie movie = new Movie();
        movie.setName("Into the Wild");
        when(movieRepository.save(movie)).thenReturn(movie);
        Movie created = moviesService.create(movie);
        assertNotNull(created);
        verify(movieRepository).save(movie);
    }

    @Test
    public void movieExists() {
        Movie movie = movies.get(0);
        Movie created = moviesService.create(movie);
        assertNull(created);
    }

    @Test
    public void isIdSet() {
        Movie movie = new Movie();
        movie.setName("Into the Wild");
        when(movieRepository.save(movie)).thenReturn(movie);
        Movie created = moviesService.create(movie);
        assertNotNull(created.getId());
        verify(movieRepository).save(movie);
    }

}
