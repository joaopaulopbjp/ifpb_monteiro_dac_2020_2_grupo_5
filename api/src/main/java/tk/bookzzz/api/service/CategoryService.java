package tk.bookzzz.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tk.bookzzz.api.model.Category;
import tk.bookzzz.api.repository.AuthorRepository;
import tk.bookzzz.api.repository.CategoryRepository;

@Service
public class CategoryService {
  
  private CategoryRepository categoryRepository;

  public Category save(Category category){
    return categoryRepository.save(category);
  }

  public List<Category> findAll(){
    return categoryRepository.findAll();
  }

  public Category findById(Long id) throws Exception{
    return categoryRepository.findById(id).orElseThrow(() -> new Exception("Category not found"));
  }

}
