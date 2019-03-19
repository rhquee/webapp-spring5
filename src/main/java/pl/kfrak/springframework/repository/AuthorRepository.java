package pl.kfrak.springframework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.kfrak.springframework.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
