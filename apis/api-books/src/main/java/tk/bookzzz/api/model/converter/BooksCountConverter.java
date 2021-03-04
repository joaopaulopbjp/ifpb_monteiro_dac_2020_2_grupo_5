package tk.bookzzz.api.model.converter;

import java.util.List;

import org.modelmapper.AbstractConverter;

import tk.bookzzz.api.model.Book;

public class BooksCountConverter extends AbstractConverter<List<Book>, Integer>{
  @Override
  protected Integer convert(List<Book> books) {

      return books.size();
  }
}
