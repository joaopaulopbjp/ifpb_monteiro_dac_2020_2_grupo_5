package tk.bookzzz.apistock.model;

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
public class Cart {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "cart_product", 
           joinColumns = { @JoinColumn(name = "product_id") }, 
           inverseJoinColumns = { @JoinColumn(name = "cart_id") })
  private List<Product> products;

}
