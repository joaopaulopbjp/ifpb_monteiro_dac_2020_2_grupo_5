package tk.bookzzz.apistock.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import lombok.Data;

@Data
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private long productInfoId;

  private double price;

  private int stockQuantity;

  @ManyToMany(mappedBy = "products")
  private List<Order> orders;

}
