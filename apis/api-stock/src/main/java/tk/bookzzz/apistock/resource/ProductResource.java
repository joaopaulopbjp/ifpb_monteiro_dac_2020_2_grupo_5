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
import tk.bookzzz.apistock.model.Product;
import tk.bookzzz.apistock.service.ProductService;

@RestController
public class ProductResource {
  

  @Autowired
  private ProductService productService;

  @PostMapping(path= Paths.Products.PATH)
  public ResponseEntity<Product> saveproduct(@RequestBody Product product){

    return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));

  }

  @GetMapping(path = Paths.Products.PATH + "/page/{pgNumber}")
  public ResponseEntity<Page<Product>> getproducts(@PathVariable int pgNumber){
    
    return ResponseEntity.status(HttpStatus.OK).body(productService.findproducts(pgNumber, 5));

  }


  @GetMapping(path = Paths.Products.PATH)
  public ResponseEntity<List<Product>> getAll(){

    return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());

  }


  @GetMapping(path = Paths.Products.PATH + "/{id}")
  public ResponseEntity<Product> getById(@PathVariable Long id){
    
    try {
      return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Product());    
    }
  }


  @PutMapping(path = Paths.Products.PATH + "/{id}")
  public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long  id){

    try {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.update(product, id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Product());
    }

  }


  @DeleteMapping(path = Paths.Products.PATH + "/{id}")
  public ResponseEntity<Product> delete(@PathVariable long id){

    try {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Product());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Product());
    }

  }

}
