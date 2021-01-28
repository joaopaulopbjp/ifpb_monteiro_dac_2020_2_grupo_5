package tk.bookzzz.api.service;

import tk.bookzzz.api.model.Author;
import tk.bookzzz.api.repository.AuthorRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  public Author save(Author author){
    return authorRepository.save(author);
  }

}
