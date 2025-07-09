package az.developia.book_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.book_project.entity.Book;
import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByUserId(Integer id);

	@Query(value = "Delete from books where user_id=?1", nativeQuery = true)
	@Modifying
	void deleteUserBooks(Integer userId);

	@Query(value = "Select title from books", nativeQuery = true)
	List<String> getBookNames();
 
	@Query(value="Select * from books limit ?1, ?2" , nativeQuery=true)
	List<Book> pagination(Integer begin, Integer length);
	

}