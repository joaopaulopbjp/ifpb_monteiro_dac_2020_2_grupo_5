package tk.bookzzz.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;


@Entity
@Data
@Table(name = "publisher")
public class Publisher implements Serializable{
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @OneToMany(mappedBy="publisher")
  private List<Book> books;
}
