package tk.bookzzz.api.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class AuthorResponseDTO {
  
  private Long id;
  private String name;
  private List<String> books;
}
