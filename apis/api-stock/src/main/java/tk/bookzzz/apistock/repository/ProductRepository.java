package tk.bookzzz.apistock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.bookzzz.apistock.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
  
}
