package tk.bookzzz.api.resource;


import java.util.ArrayList;

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
import tk.bookzzz.api.model.dto.BookGetDTO;
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
  public ResponseEntity<BookGetDTO> saveAuthor(@RequestBody BookPostDTO book){
    Book newBook = modelMapper.map(book, Book.class);

    newBook.setAuthors(new ArrayList<Author>());
    try {
      for(Long id: book.getAuthorsIds()){
        Author author = authorService.findById(id);
        author.getBooks().add(newBook);
        newBook.getAuthors().add(author);
      }
      Book savedBook = bookService.save(newBook);
      return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedBook, BookGetDTO.class));
      
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BookGetDTO());
    }
  }

  @GetMapping(path = "/books")
  public ResponseEntity<Page<BookGetDTO>> getBooks(){
    return getPageBooks(0);
  }

  @GetMapping(path = "/books/page/{pgNumber}")
  public ResponseEntity<Page<BookGetDTO>> getPageBooks(@PathVariable int pgNumber){
    Page<Book> page  = bookService.findBooks(pgNumber, 5);
    Page<BookGetDTO> pageDTO = page.map(Book -> modelMapper.map(Book, BookGetDTO.class));
    return ResponseEntity.status(HttpStatus.OK).body(pageDTO);
  }

  @PutMapping(path = "/books/{id}")
  public ResponseEntity<BookGetDTO> update(@PathVariable long id, @RequestBody BookPostDTO book){
    Book newBook = modelMapper.map(book, Book.class);

    newBook.setAuthors(new ArrayList<Author>());
    try {
      Book helpBook = bookService.findById(id);
      for(Author author: helpBook.getAuthors()){
        author.getBooks().remove(helpBook);
      }
      for(Long authorId: book.getAuthorsIds()){
        Author author = authorService.findById(authorId);
        author.getBooks().add(newBook);
        newBook.getAuthors().add(author);
      }
      newBook.setId(id);
      Book savedBook = bookService.save(newBook);
      return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(savedBook, BookGetDTO.class));
      
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BookGetDTO());
    }
  }

  @DeleteMapping(path = "/books/{id}")
  public ResponseEntity<BookGetDTO> deleteBook(@PathVariable long id){
    try {
      Book book = bookService.findById(id);
      for(Author author: book.getAuthors()){
        author.getBooks().remove(book);
      }
      bookService.delete(id);
      return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(book, BookGetDTO.class));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BookGetDTO());
    }
    
  }
}
