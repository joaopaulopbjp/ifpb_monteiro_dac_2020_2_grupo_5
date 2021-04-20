package tk.bookzzz.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.bookzzz.api.model.User;
import tk.bookzzz.api.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User save(User user){
    return userRepository.save(user);
  }

  public User update(User user, Long id) throws Exception{
    User updateduser = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    
    updateduser.setName(Optional.ofNullable(user.getName()).orElse(updateduser.getName()));
    updateduser.setEmail(Optional.ofNullable(user.getEmail()).orElse(updateduser.getEmail()));
    updateduser.setPassword(Optional.ofNullable(user.getPassword()).orElse(updateduser.getPassword()));
    
    return save(updateduser);
  }

  public void delete(Long id)throws Exception{
    User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));;
    userRepository.delete(user);
  }

  public User findById(long id) throws Exception{
    return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
  }
  
}
