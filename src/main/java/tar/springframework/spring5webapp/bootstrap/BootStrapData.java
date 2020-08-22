package tar.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tar.springframework.spring5webapp.domain.Author;
import tar.springframework.spring5webapp.domain.Book;
import tar.springframework.spring5webapp.repositories.AuthorRepository;
import tar.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author graham = new Author("Benjamin", "Graham");
        Book ii = new Book("Intelligent Investor", " 312322");
        graham.getBooks().add(ii);
        ii.getAuthors().add(graham);

        authorRepository.save(graham);
        bookRepository.save(ii);

        Author jack = new Author("Jack", "Traut");
        Book posit = new Book("Positioning", "341142");
        jack.getBooks().add(posit);
        posit.getAuthors().add(jack);

        authorRepository.save(jack);
        bookRepository.save(posit);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());


    }
}
