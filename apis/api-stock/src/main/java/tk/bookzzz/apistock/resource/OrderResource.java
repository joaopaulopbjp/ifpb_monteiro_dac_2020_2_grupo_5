package tk.bookzzz.apistock.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tk.bookzzz.apistock.model.Order;
import tk.bookzzz.apistock.service.OrderService;

@RestController
public class OrderResource {
  
  @Autowired
  private OrderService orderService;

  @PostMapping(path= Paths.Orders.PATH)
  public ResponseEntity<Order> saveOrder(@RequestBody Order order){

    return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));

  }

  @GetMapping(path = Paths.Orders.PATH + "/page/{pgNumber}")
  public ResponseEntity<Page<Order>> getOrders(@PathVariable int pgNumber){
    
    return ResponseEntity.status(HttpStatus.OK).body(orderService.findorders(pgNumber, 5));

  }


  @GetMapping(path = Paths.Orders.PATH)
  public ResponseEntity<List<Order>> getAll(){

    return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());

  }


  @GetMapping(path = Paths.Orders.PATH + "/{id}")
  public ResponseEntity<Order> getById(@PathVariable Long id){
    
    try {
      return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Order());    
    }
  }


  @PutMapping(path = Paths.Orders.PATH + "/{id}")
  public ResponseEntity<Order> update(@RequestBody Order order, @PathVariable Long  id){

    try {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.update(order, id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Order());
    }

  }


  @DeleteMapping(path = Paths.Orders.PATH + "/{id}")
  public ResponseEntity<Order> delete(@PathVariable long id){

    try {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Order());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Order());
    }

  }
}
