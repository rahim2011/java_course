package az.developia.book_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.book_project.entity.Book;
import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByUserId(Integer id);

	@Query(value = "Delete from movies where user_id=?1",nativeQuery = true)
	@Modifying
	void deleteUserBooks(Integer userId);

	@Query(value = "Select title from movies",nativeQuery = true)
	List<String> getMovieNames();

}

