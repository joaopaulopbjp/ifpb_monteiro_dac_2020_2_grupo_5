package tk.bookzzz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.bookzzz.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
