package tk.bookzzz.api.resource;

public interface Paths {

  String VERSION_APP = "/books/v1";

  interface Books {
    String URI = "/books";
    String PATH = VERSION_APP + URI;
  }
  
  interface Authors {
    String URI = "/authors";
    String PATH = VERSION_APP + URI;
  }

  interface Categories {
    String URI = "/categories";
    String PATH = VERSION_APP + URI;
  }

  interface Publishers {
    String URI = "/publishers";
    String PATH = VERSION_APP + URI;
  }
}
