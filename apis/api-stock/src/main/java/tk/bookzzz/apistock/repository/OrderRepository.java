package tk.bookzzz.apistock.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import tk.bookzzz.apistock.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
  
}
