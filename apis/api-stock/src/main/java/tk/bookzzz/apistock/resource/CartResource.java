package tk.bookzzz.apistock.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tk.bookzzz.apistock.model.Cart;
import tk.bookzzz.apistock.service.CartService;

@RestController
public class CartResource {
  

  @Autowired
  private CartService cartService;

  @PostMapping(path= Paths.Carts.PATH)
  public ResponseEntity<Cart> savecart(@RequestBody Cart cart){

    return ResponseEntity.status(HttpStatus.CREATED).body(cartService.save(cart));

  }



  @GetMapping(path = Paths.Carts.PATH + "/{id}")
  public ResponseEntity<Cart> getById(@PathVariable Long id){
    
    try {
      return ResponseEntity.status(HttpStatus.OK).body(cartService.findById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Cart());    
    }
  }


  @PutMapping(path = Paths.Carts.PATH + "/{id}")
  public ResponseEntity<Cart> update(@RequestBody Cart cart, @PathVariable Long  id){

    try {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.update(cart, id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Cart());
    }

  }


  @DeleteMapping(path = Paths.Carts.PATH + "/{id}")
  public ResponseEntity<Cart> delete(@PathVariable long id){

    try {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Cart());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Cart());
    }

  }

}
