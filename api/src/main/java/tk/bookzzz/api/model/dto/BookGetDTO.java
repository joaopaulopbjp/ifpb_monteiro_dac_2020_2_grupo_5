package tk.bookzzz.api.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookGetDTO {
  
  private Long id;
  private String title;
  private String subtitle;

  private List<String> authors;
  private int year;
  private double price;
}
