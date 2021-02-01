package tk.bookzzz.api.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
@Data
@Table(name = "author")
public class Author implements Serializable{

  private static final long serialVersionUID = 1L;

  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @ManyToMany
  @JoinTable(
  name = "book_author", 
  joinColumns = @JoinColumn(name = "author_id"), 
  inverseJoinColumns = @JoinColumn(name = "book_id")
  )
  private List<Book> books;

}
