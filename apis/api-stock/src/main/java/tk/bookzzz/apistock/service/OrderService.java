package tk.bookzzz.apistock.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tk.bookzzz.apistock.model.Order;
import tk.bookzzz.apistock.repository.OrderRepository;

@Service
public class OrderService {
  
  @Autowired
  private OrderRepository orderRepository;

  public Order save(Order order){
    return orderRepository.save(order);
  }

  public Order update(Order order, Long id) throws Exception{
    Order updatedOrder = orderRepository.findById(id).orElseThrow(() -> new Exception("Order not found"));
    
    updatedOrder.setProducts(Optional.ofNullable(order.getProducts()).orElse(updatedOrder.getProducts()));
    updatedOrder.setTimestamp(Optional.ofNullable(order.getTimestamp()).orElse(updatedOrder.getTimestamp()));
    updatedOrder.setTotal(Optional.ofNullable(order.getTotal()).orElse(updatedOrder.getTotal()));
    
    return save(updatedOrder);
  }

  public void delete(Long id)throws Exception{
    Order order = orderRepository.findById(id).orElseThrow(() -> new Exception("Order not found"));;
    orderRepository.delete(order);
  }

  public Page<Order> findorders(int page, int size){
    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "timestamp");
    return orderRepository.findAll(pageRequest);
  }

  public List<Order> findAll(){
    return orderRepository.findAll();
  }

  public Order findById(long id) throws Exception{
    return orderRepository.findById(id).orElseThrow(() -> new Exception("Order not found"));
  }
}
