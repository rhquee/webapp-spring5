package pl.kfrak.springframework.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kfrak.springframework.model.Book;

public interface BookRepository  extends CrudRepository<Book, Long> {
}
