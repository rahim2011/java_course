package az.developia.book_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.book_project.entity.Authorities;

public interface AuthorityRepository extends JpaRepository<Authorities, Integer> {

	List<Authorities> findByUsername(String username);

}
