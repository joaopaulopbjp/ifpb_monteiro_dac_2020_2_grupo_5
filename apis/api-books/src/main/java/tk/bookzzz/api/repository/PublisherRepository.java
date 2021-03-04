package tk.bookzzz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.bookzzz.api.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{
  
}
