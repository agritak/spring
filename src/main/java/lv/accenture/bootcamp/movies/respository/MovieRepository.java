package lv.accenture.bootcamp.movies.respository;

import java.util.List;

public interface MovieRepository { //extends CrudRepository<Movie, String> {
    List<Movie> findByNameContains(String name);
}
