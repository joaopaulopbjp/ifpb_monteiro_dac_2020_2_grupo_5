package tk.bookzzz.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.bookzzz.api.model.Category;
import tk.bookzzz.api.model.Book;
import tk.bookzzz.api.model.dto.CategoryGetDTO;
import tk.bookzzz.api.service.CategoryService;

@RestController
public class CategoryResource {
  

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping(path= "/categories")
  public ResponseEntity<Category> saveCategory(@RequestBody Category category){
    category.setBooks(new ArrayList<Book>());
    Category savedCategory = categoryService.save(category);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
  }

  @GetMapping(path= "/categories")
  public ResponseEntity<List<CategoryGetDTO>> getCategories(){
    List<Category> categories  = categoryService.findAll();
    List<CategoryGetDTO> categoriesGetDTO = categories.stream()
      .map(category -> modelMapper.map(category, CategoryGetDTO.class))
      .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(categoriesGetDTO);
  }

  @GetMapping(path= "/categories/{id}")
  public ResponseEntity<CategoryGetDTO> getCategory(@PathVariable Long id){
    try {
      Category category = categoryService.findById(id);
      CategoryGetDTO categoryGetDTO= modelMapper.map(category, CategoryGetDTO.class);
      return ResponseEntity.status(HttpStatus.OK).body(categoryGetDTO);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CategoryGetDTO());
    }
  }


}
