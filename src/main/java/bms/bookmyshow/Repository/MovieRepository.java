package bms.bookmyshow.Repository;

import bms.bookmyshow.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
