package pl.kfrak.springframework.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.kfrak.springframework.model.Author;
import pl.kfrak.springframework.model.Book;
import pl.kfrak.springframework.model.Publisher;
import pl.kfrak.springframework.repository.AuthorRepository;
import pl.kfrak.springframework.repository.BookRepository;
import pl.kfrak.springframework.repository.PublisherRepository;

/*
ContextRefreshEvent:
- is fired once when the ApplicationContext is fully loaded;
- it is fired when properties, xml or any schema files are loaded/refreshed.
 */

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    //bo iniekcja zależna
    public ApplicationStartup(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        Publisher publisher = new Publisher();
        publisher.setName("PUBL");

        publisherRepository.save(publisher);

        Author sucre = new Author("Sucre", "Sugar");
        Book sucreBook = new Book("Everything for my angel", "123", publisher);
        sucre.getBooks().add(sucreBook);
        sucreBook.getAuthors().add(sucre);

        authorRepository.save(sucre);
        bookRepository.save(sucreBook);

        Author teddy = new Author("T", "Bag");
        Book teddyBook = new Book("Get my money!", "666", publisher);
        teddy.getBooks().add(teddyBook);

        authorRepository.save(teddy);
        bookRepository.save(teddyBook);


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
