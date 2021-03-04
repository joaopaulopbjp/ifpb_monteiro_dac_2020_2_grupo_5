package tk.bookzzz.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.bookzzz.api.model.Publisher;
import tk.bookzzz.api.repository.PublisherRepository;

@Service
public class PublisherService {

  @Autowired
  private PublisherRepository publisherRepository;

  public Publisher save(Publisher publisher){
    return publisherRepository.save(publisher);
  }

  public List<Publisher> findAll(){
    return publisherRepository.findAll();
  }

  public Publisher findById(Long id) throws Exception{
    return publisherRepository.findById(id).orElseThrow(() -> new Exception("Publisher not found"));
  }
  
}
