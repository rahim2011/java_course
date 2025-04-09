package az.developia.book_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.book_project.entity.Book;

	public interface BookRepository extends JpaRepository<Book,Integer>{

	}

