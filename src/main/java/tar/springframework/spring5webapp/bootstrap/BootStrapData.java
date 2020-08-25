package tar.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tar.springframework.spring5webapp.domain.Author;
import tar.springframework.spring5webapp.domain.Book;
import tar.springframework.spring5webapp.domain.Publisher;
import tar.springframework.spring5webapp.repositories.AuthorRepository;
import tar.springframework.spring5webapp.repositories.BookRepository;
import tar.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author graham = new Author("Benjamin", "Graham");
        Book ii = new Book("Intelligent Investor", " 312322");
        graham.getBooks().add(ii);
        ii.getAuthors().add(graham);

        ii.setPublisher(publisher);
        publisher.getBooks().add(ii);

        authorRepository.save(graham);
        bookRepository.save(ii);
        publisherRepository.save(publisher);

        Author jack = new Author("Jack", "Traut");
        Book posit = new Book("Positioning", "341142");
        jack.getBooks().add(posit);
        posit.getAuthors().add(jack);

        posit.setPublisher(publisher);
        publisher.getBooks().add(ii);

        authorRepository.save(jack);
        bookRepository.save(posit);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());


    }
}
