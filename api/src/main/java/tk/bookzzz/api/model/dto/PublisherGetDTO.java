package tk.bookzzz.api.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class PublisherGetDTO {
  
  private Long id;
  private String name;
  private List<String> books;
}
