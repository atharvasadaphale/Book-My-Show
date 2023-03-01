package bms.bookmyshow.Repository;

import bms.bookmyshow.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    //springdoc-openapi-ui
    //springfox-swagger2
    //springfox-swagger-ui
}
