package az.developia.book_project.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "my_view")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {

	@Id
	private Integer movieId;
	private String movieTitle;
	private Integer userId;
	private String userName;
}