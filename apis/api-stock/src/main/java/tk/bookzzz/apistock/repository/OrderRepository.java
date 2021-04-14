package tk.bookzzz.apistock.repository;



import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import tk.bookzzz.apistock.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
  
  Page<Order> findAll(Pageable pageable);
  
}
