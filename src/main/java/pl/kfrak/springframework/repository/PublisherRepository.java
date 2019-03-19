package pl.kfrak.springframework.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kfrak.springframework.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
