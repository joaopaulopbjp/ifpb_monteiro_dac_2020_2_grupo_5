package tk.bookzzz.apistock.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Order {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime timestamp;

  @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_product", 
             joinColumns = { @JoinColumn(name = "product_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "order_id") })
  private List<Product> products;

  private double total;
}
