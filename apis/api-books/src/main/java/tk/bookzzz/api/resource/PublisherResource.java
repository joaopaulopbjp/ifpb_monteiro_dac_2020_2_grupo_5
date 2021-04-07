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

import tk.bookzzz.api.model.Publisher;
import tk.bookzzz.api.model.Book;
import tk.bookzzz.api.model.dto.PublisherResponseDTO;
import tk.bookzzz.api.service.PublisherService;

@RestController
public class PublisherResource {

  @Autowired
  private PublisherService publisherService;

  @Autowired
  private ModelMapper modelMapper;


  @PostMapping(path= Paths.Publishers.PATH)
  public ResponseEntity<PublisherResponseDTO> savePublisher(@RequestBody Publisher publisher){
    publisher.setBooks(new ArrayList<Book>());
    Publisher savedPublisher = publisherService.save(publisher);
    return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedPublisher, PublisherResponseDTO.class));
  }

  @GetMapping(path= Paths.Publishers.PATH)
  public ResponseEntity<List<PublisherResponseDTO>> getPublishers(){
    List<Publisher> publishers  = publisherService.findAll();
    List<PublisherResponseDTO> publishersGetDTO = publishers.stream()
      .map(publisher -> modelMapper.map(publisher, PublisherResponseDTO.class))
      .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(publishersGetDTO);
  }

  @GetMapping(path= Paths.Publishers.PATH + "/{id}")
  public ResponseEntity<PublisherResponseDTO> getPublisher(@PathVariable Long id){
    try {
      Publisher publisher = publisherService.findById(id);
      PublisherResponseDTO publisherGetDTO= modelMapper.map(publisher, PublisherResponseDTO.class);
      return ResponseEntity.status(HttpStatus.OK).body(publisherGetDTO);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PublisherResponseDTO());
    }
  }
  
}
