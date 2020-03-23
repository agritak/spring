package lv.accenture.bootcamp.movies.respository;

//@Service
public class MoviesService {

    //@Autowired
    private MovieRepository repository;

//    public Iterable<Movie> movies() {
//        return repository.findAll();
//    }
//
//    public Movie create(Movie movie) {
//        for (Movie m : movies()) {
//            if (m.equals(movie)) {
//                return null;
//            }
//        }
//        movie.setId(UUID.randomUUID().toString());
//        repository.save(movie);
//        return movie;
//    }
//
//
//    public void update(String id, Movie movie) {
//        Optional<Movie> optional = repository.findById(id);
//        if (optional.isPresent()) {
//            Movie m = optional.get();
//            m.setName(movie.getName());
//            m.setRating(movie.getRating());
//            m.setDescription(movie.getDescription());
//            repository.save(m);
//        }
//    }
//
//    public void delete(String id) {
//        repository.deleteById(id);
//    }
//
//    public Iterable<Movie> sort(Sorting order) {
//        Iterable<Movie> iterable = movies();
//        List<Movie> movies = new ArrayList<>();
//        iterable.forEach(movies::add);
//        movies.sort(order.getComparator());
//        return movies;
//    }
//
//    public Iterable<Movie> search(String keyword) {
//        return repository.findByNameContains(keyword);
//    }
}
