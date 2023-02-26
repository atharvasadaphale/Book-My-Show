package bms.bookmyshow.Repository;

import bms.bookmyshow.Entities.Theatre;
import bms.bookmyshow.Entities.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeat,Integer> {
}
