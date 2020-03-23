package lv.accenture.bootcamp.movies.jdbc;

import lv.accenture.bootcamp.movies.respository.Movie;
import lv.accenture.bootcamp.movies.respository.Sorting;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Service
public class MoviesService {

    //@Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movie> movies() {
        return jdbcTemplate.query("SELECT * FROM movies", this::mapRowToMovie);
    }

    public Movie create(Movie movie) {
        List<Movie> movies = movies();
        for (Movie m : movies) {
            if (m.equals(movie)) {
                return null;
            }
        }
        movie.setId(UUID.randomUUID().toString());
        String sqlQuery = "INSERT INTO movies VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sqlQuery,
                movie.getId(),
                movie.getName(),
                movie.getRating(),
                movie.getDescription());
        return movie;
    }


    public int update(String id, Movie movie) {
        String sqlQuery = "UPDATE movies SET title = ?, rating = ?, plot = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(sqlQuery
                , movie.getName()
                , movie.getRating()
                , movie.getDescription()
                , id);
    }

    public boolean delete(String id) {
        String sqlQuery = "DELETE FROM movies WHERE id = ?";
        return jdbcTemplate.update(sqlQuery, id) > 0;
    }

    public List<Movie> sort(Sorting order) {
        List<Movie> movies = movies();
        movies.sort(order.getComparator());
        return movies;
    }

    public List<Movie> search(String keyword) {
        List<Movie> found = new ArrayList<>();
        for (Movie movie : movies()) {
            if (movie.getName().toLowerCase().contains(keyword.toLowerCase())) {
                found.add(movie);
            }
        }
        return found;

    }

    private Movie mapRowToMovie(ResultSet resultSet, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getString("id"));
        movie.setName(resultSet.getString("title"));
        movie.setRating(resultSet.getFloat("rating"));
        movie.setDescription(resultSet.getString("plot"));
        return movie;
    }
}

