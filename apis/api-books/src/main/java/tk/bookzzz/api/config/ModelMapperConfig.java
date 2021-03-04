package tk.bookzzz.api.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.bookzzz.api.model.Category;
import tk.bookzzz.api.model.Publisher;
import tk.bookzzz.api.model.Author;
import tk.bookzzz.api.model.Book;
import tk.bookzzz.api.model.converter.AuthorsListConverter;
import tk.bookzzz.api.model.converter.BooksCountConverter;
import tk.bookzzz.api.model.converter.BooksListConverter;
import tk.bookzzz.api.model.dto.CategoryGetDTO;
import tk.bookzzz.api.model.dto.PublisherGetDTO;
import tk.bookzzz.api.model.dto.AuthorGetDTO;
import tk.bookzzz.api.model.dto.BookGetDTO;

@Configuration
public class ModelMapperConfig {
  
  @Bean
  public ModelMapper modelMapper(){
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
    .setFieldMatchingEnabled(true)
    .setFieldAccessLevel(AccessLevel.PRIVATE);

    
    TypeMap<Book, BookGetDTO> bookTypeMap;
    bookTypeMap = modelMapper.createTypeMap(Book.class, BookGetDTO.class);
    bookTypeMap.addMappings(
      bookMapper -> bookMapper.using(new AuthorsListConverter())
      .map(Book::getAuthors, BookGetDTO::setAuthors)
      );
    

    TypeMap<Category, CategoryGetDTO> categoryTypeMap;
    categoryTypeMap = modelMapper.createTypeMap(Category.class, CategoryGetDTO.class);
    categoryTypeMap.addMappings(
      categoryMapper -> categoryMapper.using(new BooksCountConverter())
      .map(Category::getBooks, CategoryGetDTO::setBooksCount)
    );


    TypeMap<Publisher, PublisherGetDTO> publisherTypeMap;
    publisherTypeMap = modelMapper.createTypeMap(Publisher.class, PublisherGetDTO.class);
    publisherTypeMap.addMappings(
      publisherMapper -> publisherMapper.using(new BooksCountConverter())
      .map(Publisher::getBooks, PublisherGetDTO::setBooksCount)
    );


    TypeMap<Author, AuthorGetDTO> authorTypeMap;
    authorTypeMap = modelMapper.createTypeMap(Author.class, AuthorGetDTO.class);
    authorTypeMap.addMappings(
      authorMapper -> authorMapper.using(new BooksListConverter())
      .map(Author::getBooks, AuthorGetDTO::setBooks)
    );
      
    
    return modelMapper;
  }
}