package tk.bookzzz.apistock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tk.bookzzz.apistock.model.Product;
import tk.bookzzz.apistock.repository.ProductRepository;


@Service
public class ProductService {
  
  @Autowired
  private ProductRepository productRepository;


  public Product save(Product product){
    return productRepository.save(product);
  }

  public Product update(Product product, Long id) throws Exception{
    Product updatedProduct = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));
    
    updatedProduct.setPrice(Optional.ofNullable(product.getPrice()).orElse(updatedProduct.getPrice()));
    updatedProduct.setProductInfoId(Optional.ofNullable(product.getProductInfoId()).orElse(updatedProduct.getProductInfoId()));
    updatedProduct.setStockQuantity(Optional.ofNullable(product.getStockQuantity()).orElse(updatedProduct.getStockQuantity()));
    
    return save(updatedProduct);
  }

  public void delete(Long id)throws Exception{
    Product product = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));;
    productRepository.delete(product);
  }

  public Page<Product> findproducts(int page, int size){
    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "price");
    return productRepository.findAll(pageRequest);
  }

  public List<Product> findAll(){
    return productRepository.findAll();
  }

  public Product findById(long id) throws Exception{
    return productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));
  }


}
