package tk.bookzzz.api.model.dto;

import lombok.Data;

@Data
public class CategoryGetDTO {
  
  private Long id;
  private String name;
  private int booksCount;

}
