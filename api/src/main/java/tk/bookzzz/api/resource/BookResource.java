package tk.bookzzz.api.resource;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.bookzzz.api.model.Author;
import tk.bookzzz.api.model.Book;
import tk.bookzzz.api.model.dto.BookPostDTO;
import tk.bookzzz.api.service.AuthorService;
import tk.bookzzz.api.service.BookService;

@RestController
public class BookResource {
  
  @Autowired
  private BookService bookService;

  @Autowired
  private AuthorService authorService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping(path= "/books")
  public ResponseEntity<Book> saveAuthor(@RequestBody BookPostDTO book){
    Book newBook = modelMapper.map(book, Book.class);
    newBook.setAuthors(new ArrayList<Author>());
    try {
      for(Long id: book.getAuthors()){
        Author author = authorService.findById(id);
        author.getBooks().add(newBook);
        newBook.getAuthors().add(author);
      }
      Book savedBook = bookService.save(newBook);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
      
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Book());
    }
  }

  @GetMapping(path = "/books")
  public ResponseEntity<List<Book>> getBooks(){
    return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
  }

  @GetMapping(path = "/books/page/{pgNumber}")
  public ResponseEntity<Page<Book>> searchBooks(@PathVariable int pgNumber){
    return ResponseEntity.status(HttpStatus.OK).body(bookService.findBooks(pgNumber, 5));
  }

  @PutMapping(path = "/books/{id}")
  public ResponseEntity<Book> update(@PathVariable long id, @RequestBody BookPostDTO book){
    Book newBook = modelMapper.map(book, Book.class);
    newBook.setAuthors(new ArrayList<Author>());
    try {
      Book helpBook = bookService.findById(id);
      for(Author author: helpBook.getAuthors()){
        author.getBooks().remove(helpBook);
      }
      for(Long authorId: book.getAuthors()){
        Author author = authorService.findById(authorId);
        author.getBooks().add(newBook);
        newBook.getAuthors().add(author);
      }
      newBook.setId(id);
      Book savedBook = bookService.save(newBook);
      return ResponseEntity.status(HttpStatus.OK).body(savedBook);
      
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Book());
    }
  }

  @DeleteMapping(path = "/books/{id}")
  public ResponseEntity<Book> deleteBook(@PathVariable long id){
    try {
      Book book = bookService.findById(id);
      for(Author author: book.getAuthors()){
        author.getBooks().remove(book);
      }
      bookService.delete(id);
      return ResponseEntity.status(HttpStatus.OK).body(book);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Book());
    }
    
  }
}
