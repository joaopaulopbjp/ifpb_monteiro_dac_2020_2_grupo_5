package tk.bookzzz.api.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Data
@NoArgsConstructor
@Table(name = "book")
public class Book implements Serializable{

  private static final long serialVersionUID = 1L;

  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;
  private String subtitle;

  @ManyToMany(mappedBy = "books")
  private List<Author> authors;
  private int year;
  private double price;

}
