package pl.kfrak.springframework.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.kfrak.springframework.model.Author;
import pl.kfrak.springframework.model.Book;
import pl.kfrak.springframework.repository.AuthorRepository;
import pl.kfrak.springframework.repository.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    //bo iniekcja zależna
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){
        Author sucre = new Author("Sucre", "Sugar");
        Book sucreBook = new Book("Everything for my angel", "123", "SS");
        sucre.getBooks().add(sucreBook);
        sucreBook.getAuthors().add(sucre);

        authorRepository.save(sucre);
        bookRepository.save(sucreBook);

        Author teddy = new Author("T", "Bag");
        Book teddyBook = new Book("Get my money!", "666", "TB");
        teddy.getBooks().add(teddyBook);

        authorRepository.save(teddy);
        bookRepository.save(teddyBook);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
