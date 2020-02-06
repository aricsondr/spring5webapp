package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    public void run(String... args) {
        try{
            Author eric = new Author("Eric", "Evens");
            Book ddd = new Book("Domain Drive Design", "123123");
            Publisher ed1 = new Publisher("Porto Editora", "Rua Nova Vilar", "Porto", "Centro", "4354534");
            eric.getBooks().add(ddd);
            ddd.getAuthors().add(eric);
            ed1.getBooks().add(ddd);

            authorRepository.save(eric);
            bookRepository.save(ddd);
            publisherRepository.save(ed1);

            Author rod = new Author("Rod", "Jonshon");
            Book eee = new Book("J2EE Development Without EJB", "456456");
            Publisher ed2 = new Publisher("London Publisher", "Hollyood", "London", "South of London", "897987451");
            rod.getBooks().add(eee);
            eee.getAuthors().add(rod);
            ed2.getBooks().add(eee);

            authorRepository.save(rod);
            bookRepository.save(eee);
            publisherRepository.save(ed2);

            System.out.println("Started in Bootstrap");
            System.out.println("Number of books: " + bookRepository.count());
            System.out.println("Number of publisher: " + publisherRepository.count());
        }
        catch(Exception e)
        {
            System.out.println("Erro: " +e);
        }
    }
}
