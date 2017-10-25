package info.gokit.demo.security.repositories;

import info.gokit.demo.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}


