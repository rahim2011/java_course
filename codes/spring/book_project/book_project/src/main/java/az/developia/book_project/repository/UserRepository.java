package az.developia.book_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import az.developia.book_project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

	User getUserByUsername(String username);

}
