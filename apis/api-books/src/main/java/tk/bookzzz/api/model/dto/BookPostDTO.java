package tk.bookzzz.api.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookPostDTO {
  
  private String title;
  private String subtitle;
  private String description;
  private String isbn;
  private int year;
  private String coverImg;

  private Long category;
  private Long publisher;
  private List<Long> authorsIds;
  
  
  
}
