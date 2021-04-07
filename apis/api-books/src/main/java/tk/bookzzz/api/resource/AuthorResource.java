package tk.bookzzz.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.bookzzz.api.model.Author;
import tk.bookzzz.api.model.Book;
import tk.bookzzz.api.model.dto.AuthorResponseDTO;
import tk.bookzzz.api.service.AuthorService;

@RestController
public class AuthorResource {

  @Autowired
  private AuthorService authorService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping(path= Paths.Authors.PATH)
  public ResponseEntity<AuthorResponseDTO> saveAuthor(@RequestBody Author author){
    author.setBooks(new ArrayList<Book>());
    Author savedAuthor = authorService.save(author);
    return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedAuthor, AuthorResponseDTO.class));
  }

  @GetMapping(path= Paths.Authors.PATH)
  public ResponseEntity<List<AuthorResponseDTO>> getAuthors(){
    List<Author> authors  = authorService.findAll();
    List<AuthorResponseDTO> authorsGetDTO = authors.stream()
      .map(author -> modelMapper.map(author, AuthorResponseDTO.class))
      .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(authorsGetDTO);
  }

  @GetMapping(path= Paths.Authors.PATH + "/{id}")
  public ResponseEntity<AuthorResponseDTO> getAuthor(@PathVariable Long id){
    try {
      Author author = authorService.findById(id);
      AuthorResponseDTO authorGetDTO = modelMapper.map(author, AuthorResponseDTO.class);
      return ResponseEntity.status(HttpStatus.OK).body(authorGetDTO);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AuthorResponseDTO());
    }
  }

  
}
