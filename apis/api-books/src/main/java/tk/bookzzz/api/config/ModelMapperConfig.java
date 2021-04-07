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
import tk.bookzzz.api.model.dto.CategoryResponseDTO;
import tk.bookzzz.api.model.dto.PublisherResponseDTO;
import tk.bookzzz.api.model.dto.AuthorResponseDTO;
import tk.bookzzz.api.model.dto.BookResponseDTO;

@Configuration
public class ModelMapperConfig {
  
  @Bean
  public ModelMapper modelMapper(){
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
    .setFieldMatchingEnabled(true)
    .setFieldAccessLevel(AccessLevel.PRIVATE);

    
    TypeMap<Book, BookResponseDTO> bookTypeMap;
    bookTypeMap = modelMapper.createTypeMap(Book.class, BookResponseDTO.class);
    bookTypeMap.addMappings(
      bookMapper -> bookMapper.using(new AuthorsListConverter())
      .map(Book::getAuthors, BookResponseDTO::setAuthors)
      );
    

    TypeMap<Category, CategoryResponseDTO> categoryTypeMap;
    categoryTypeMap = modelMapper.createTypeMap(Category.class, CategoryResponseDTO.class);
    categoryTypeMap.addMappings(
      categoryMapper -> categoryMapper.using(new BooksCountConverter())
      .map(Category::getBooks, CategoryResponseDTO::setBooksCount)
    );


    TypeMap<Publisher, PublisherResponseDTO> publisherTypeMap;
    publisherTypeMap = modelMapper.createTypeMap(Publisher.class, PublisherResponseDTO.class);
    publisherTypeMap.addMappings(
      publisherMapper -> publisherMapper.using(new BooksCountConverter())
      .map(Publisher::getBooks, PublisherResponseDTO::setBooksCount)
    );


    TypeMap<Author, AuthorResponseDTO> authorTypeMap;
    authorTypeMap = modelMapper.createTypeMap(Author.class, AuthorResponseDTO.class);
    authorTypeMap.addMappings(
      authorMapper -> authorMapper.using(new BooksListConverter())
      .map(Author::getBooks, AuthorResponseDTO::setBooks)
    );
      
    
    return modelMapper;
  }
}
