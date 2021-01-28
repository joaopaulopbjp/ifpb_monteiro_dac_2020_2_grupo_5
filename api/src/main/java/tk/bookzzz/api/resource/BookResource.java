package tk.bookzzz.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.bookzzz.api.model.Author;
import tk.bookzzz.api.service.AuthorService;

@RestController
public class BookResource {
  
  @Autowired
  private AuthorService authorService;

  @PostMapping(path= "/authors")
  public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
    Author savedAuthor = authorService.save(author);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
  }

  @GetMapping(path= "/authors")
  public ResponseEntity<String> getAuthors(){
    return ResponseEntity.status(HttpStatus.OK).body("ok: vapo");
  }

}
