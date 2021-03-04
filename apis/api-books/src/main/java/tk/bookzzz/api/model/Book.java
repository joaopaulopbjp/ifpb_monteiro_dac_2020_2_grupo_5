package tk.bookzzz.api.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Data
@Table(name = "book")
public class Book implements Serializable{

  private static final long serialVersionUID = 1L;

  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String subtitle;
  private String description;
  private String isbn;
  private int year;
  private String coverImg;

  @ManyToOne
  @JoinColumn(name="category_id", nullable=false)
  private Category category;

  @ManyToOne
  @JoinColumn(name="publisher_id", nullable=false)
  private Publisher publisher;
  

  @ManyToMany(mappedBy = "books")
  private List<Author> authors; 

}
