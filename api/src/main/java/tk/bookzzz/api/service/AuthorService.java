package tk.bookzzz.api.service;

import tk.bookzzz.api.model.Author;
import tk.bookzzz.api.repository.AuthorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  public Author save(Author author){
    return authorRepository.save(author);
  }

  public List<Author> findAll(){
    return authorRepository.findAll();
  }

  public Author findById(long id) throws Exception{
    return authorRepository.findById(id).orElseThrow(() -> new Exception("Author not found"));
  }

}
