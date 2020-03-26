package lv.accenture.bootcamp.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MoviesServiceTest {
    // @Mock šo anotāciju varat izmantot priekš mock objektiem
    // @InjectMocks izmantosiet lai anotētu savu servisu

//    @InjectMocks
//    private MoviesService moviesService = new MoviesService();
//    @Mock
//    private MovieRepository movieRepository;
//
//    private List<Movie> movies;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//
//        Movie movie1 = new Movie();
//        movie1.setName("Movie1");
//        Movie movie2 = new Movie();
//        movie2.setName("Movie2");
//
//        movies = Arrays.asList(movie1, movie2, new Movie());
//        when(movieRepository.findAll()).thenReturn(movies);
//    }
//
//    @Test
//    public void movies() {
//        List<Movie> list = (List<Movie>) moviesService.movies();
//        int expected = 3;
//        int actual = list.size();
//        assertEquals("There should be 3 movies in the list.", expected, actual);
//        verify(movieRepository).findAll();
//    }
//
//    @Test
//    public void createNewMovie() {
//        Movie movie = new Movie();
//        movie.setName("Into the Wild");
//        when(movieRepository.save(movie)).thenReturn(movie);
//        Movie created = moviesService.create(movie);
//        assertNotNull(created);
//        verify(movieRepository).save(movie);
//    }
//
//    @Test
//    public void movieExists() {
//        Movie movie = movies.get(0);
//        Movie created = moviesService.create(movie);
//        assertNull(created);
//    }
//
//    @Test
//    public void isIdSet() {
//        Movie movie = new Movie();
//        movie.setName("Into the Wild");
//        when(movieRepository.save(movie)).thenReturn(movie);
//        Movie created = moviesService.create(movie);
//        assertNotNull(created.getId());
//        verify(movieRepository).save(movie);
//    }

}
