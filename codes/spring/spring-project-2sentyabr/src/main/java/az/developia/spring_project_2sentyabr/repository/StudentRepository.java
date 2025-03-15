package az.developia.spring_project_2sentyabr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import az.developia.spring_project_2sentyabr.entity.Student;

public interface StudentRepository extends JpaRepository<Student,ID>{

}
