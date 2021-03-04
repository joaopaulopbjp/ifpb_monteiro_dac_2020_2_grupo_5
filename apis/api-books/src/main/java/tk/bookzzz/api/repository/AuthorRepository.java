package tk.bookzzz.api.repository;

import tk.bookzzz.api.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long>{

}
