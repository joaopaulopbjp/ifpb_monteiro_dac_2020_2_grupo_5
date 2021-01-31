package tk.bookzzz.api.resource;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.bookzzz.api.model.Author;
import tk.bookzzz.api.service.AuthorService;

@RestController
public class AuthorResource {

  @Autowired
  private AuthorService authorService;

  @PostMapping(path= "/authors")
  public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
    Author savedAuthor = authorService.save(author);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
  }

  @GetMapping(path= "/authors")
  public ResponseEntity<List<Author>> getAuthors(){
    return ResponseEntity.status(HttpStatus.OK).body(authorService.findAll());
  }

  @GetMapping(path= "/authors/{id}")
  public ResponseEntity<Author> getAuthor(@PathVariable Long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(authorService.findById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Author());
    }
  }

  
}
