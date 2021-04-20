package tk.bookzzz.api.resource;

public interface Paths {

  String VERSION_APP = "/books/v1";

  interface Users {
    String URI = "/users";
    String PATH = VERSION_APP + URI;
  }


}