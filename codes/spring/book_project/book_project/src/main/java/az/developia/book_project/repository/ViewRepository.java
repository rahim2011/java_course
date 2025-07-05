package az.developia.book_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.book_project.entity.TestEntity;



public interface ViewRepository extends JpaRepository<TestEntity, Integer>{

}