package tk.bookzzz.api.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookGetDTO {
  
  private Long id;
  private String title;
  private String subtitle;
  private String description;
  private String isbn;
  private int year;
  private String coverImg;

  private String categoryName;
  private String publisherName;
  private List<String> authors;

}
