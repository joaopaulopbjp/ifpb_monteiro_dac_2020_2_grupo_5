package tk.bookzzz.api.service;

import tk.bookzzz.api.model.Book;
import tk.bookzzz.api.repository.BookRepository;

import org.springframework.stereotype.Service;
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
    Book book = bookRepository.findById(updatedBook.getId()).orElseThrow(() -> new Exception("Book not finded"));
    book.setTitle(updatedBook.getTitle());
    book.setSubtitle(updatedBook.getSubtitle());
    book.setAuthors(updatedBook.getAuthors());
    book.setYear(updatedBook.getYear());
    book.setPrice(updatedBook.getPrice());

    return save(book);
  }
  
  public void delete(Long id)throws Exception{
    Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not finded"));;
    bookRepository.delete(book);
  }

  public Page<Book> findBooks(String search, int page, int size){
    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "price");
    return bookRepository.findAllByTitle(search, pageRequest);
  }


}
