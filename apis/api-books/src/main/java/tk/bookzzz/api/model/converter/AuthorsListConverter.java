package tk.bookzzz.api.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import tk.bookzzz.api.model.Author;

public class AuthorsListConverter extends AbstractConverter<List<Author>, List<String>>{
  @Override
  protected List<String> convert(List<Author> authors) {

      return authors
        .stream()
        .map(Author::getName)
        .collect(Collectors.toList());
  }
}
