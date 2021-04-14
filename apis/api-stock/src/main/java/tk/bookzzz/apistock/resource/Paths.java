package tk.bookzzz.apistock.resource;

public interface Paths {

  String VERSION_APP = "/books/v1";

  interface Orders {
    String URI = "/orders";
    String PATH = VERSION_APP + URI;
  }
  
  interface Carts {
    String URI = "/carts";
    String PATH = VERSION_APP + URI;
  }

  interface Products {
    String URI = "/products";
    String PATH = VERSION_APP + URI;
  }

}