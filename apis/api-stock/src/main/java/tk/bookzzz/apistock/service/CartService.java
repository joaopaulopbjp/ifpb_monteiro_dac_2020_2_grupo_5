package tk.bookzzz.apistock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.bookzzz.apistock.model.Cart;
import tk.bookzzz.apistock.repository.CartRepository;

@Service
public class CartService {
  
  @Autowired
  private CartRepository cartRepository;

  public Cart save(Cart cart){
    return cartRepository.save(cart);
  }

  public Cart update(Cart cart, Long id) throws Exception{
    Cart updatedcart = cartRepository.findById(id).orElseThrow(() -> new Exception("Cart not found"));
    
    updatedcart.setProducts(Optional.ofNullable(cart.getProducts()).orElse(updatedcart.getProducts()));
    
    return save(updatedcart);
  }

  public void delete(Long id)throws Exception{
    Cart cart = cartRepository.findById(id).orElseThrow(() -> new Exception("Cart not found"));;
    cartRepository.delete(cart);
  }

  public Cart findById(long id) throws Exception{
    return cartRepository.findById(id).orElseThrow(() -> new Exception("Cart not found"));
  }
}
