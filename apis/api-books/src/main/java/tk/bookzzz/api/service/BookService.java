package tk.bookzzz.api.service;

import tk.bookzzz.api.model.Book;
import tk.bookzzz.api.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public Book save(Book book){
    return bookRepository.save(book);
  }

  public Book update(Book updatedBook) throws Exception{
    Book book = bookRepository.findById(updatedBook.getId()).orElseThrow(() -> new Exception("Book not found"));
    
    book.setTitle(Optional.ofNullable(updatedBook.getTitle()).orElse(book.getTitle()));
    book.setSubtitle(Optional.ofNullable(updatedBook.getSubtitle()).orElse(book.getSubtitle()));
    book.setDescription(Optional.ofNullable(updatedBook.getDescription()).orElse(book.getDescription()));
    book.setIsbn(Optional.ofNullable(updatedBook.getIsbn()).orElse(book.getIsbn()));
    book.setYear(Optional.ofNullable(updatedBook.getYear()).orElse(book.getYear()));
    book.setCoverImg(Optional.ofNullable(updatedBook.getCoverImg()).orElse(book.getCoverImg()));
    book.setCategory(Optional.ofNullable(updatedBook.getCategory()).orElse(book.getCategory()));
    book.setPublisher(Optional.ofNullable(updatedBook.getPublisher()).orElse(book.getPublisher()));
    book.setAuthors(Optional.ofNullable(updatedBook.getAuthors()).orElse(book.getAuthors()));

    return save(book);
  }
  
  public void delete(Long id)throws Exception{
    Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));;
    bookRepository.delete(book);
  }

  public Page<Book> findBooks(int page, int size){
    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "title");
    return bookRepository.findAll(pageRequest);
  }

  public List<Book> findAll(){
    return bookRepository.findAll();
  }

  public Book findById(long id) throws Exception{
    return bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));
  }

}
