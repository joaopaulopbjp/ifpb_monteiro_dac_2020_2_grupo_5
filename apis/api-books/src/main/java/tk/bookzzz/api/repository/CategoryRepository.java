package tk.bookzzz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.bookzzz.api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
  
}
