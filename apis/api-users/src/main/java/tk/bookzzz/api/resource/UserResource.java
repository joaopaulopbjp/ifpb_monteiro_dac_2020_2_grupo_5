package tk.bookzzz.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.bookzzz.api.model.User;
import tk.bookzzz.api.service.UserService;

@RestController
public class UserResource {
  
  @Autowired
  private UserService userService;

  @PostMapping(path= Paths.Users.PATH)
  public ResponseEntity<User> saveuser(@RequestBody User user){

    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));

  }



  @GetMapping(path = Paths.Users.PATH + "/{id}")
  public ResponseEntity<User> getById(@PathVariable Long id){
    
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new User());    
    }
  }


  @PutMapping(path = Paths.Users.PATH + "/{id}")
  public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long  id){

    try {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.update(user, id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new User());
    }

  }


  @DeleteMapping(path = Paths.Users.PATH + "/{id}")
  public ResponseEntity<User> delete(@PathVariable long id){

    try {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(new User());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new User());
    }

  }
}
