package tk.bookzzz.apistock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.bookzzz.apistock.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
  
}
