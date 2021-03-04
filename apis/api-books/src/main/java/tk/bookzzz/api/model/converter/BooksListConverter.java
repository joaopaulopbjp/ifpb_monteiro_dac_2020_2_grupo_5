package tk.bookzzz.api.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import tk.bookzzz.api.model.Book;

public class BooksListConverter extends AbstractConverter<List<Book>, List<String>>{
  @Override
  protected List<String> convert(List<Book> books) {

      return books
        .stream()
        .map(Book::getTitle)
        .collect(Collectors.toList());
  }
}