package com.main.product_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.main.product_app.dao.ProductRequest;
import com.main.product_app.entity.Category;
import com.main.product_app.entity.Product;
import com.main.product_app.exception.CategoryNotFoundException;
import com.main.product_app.repository.CategoryRepository;
import com.main.product_app.repository.ProductRepository;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  public Product InsertProducts(ProductRequest productRequest) throws Exception
  {
      Product product = Product.builder()
      .categoryId(productRequest.getCategoryId())
      .title(productRequest.getTitle())
      .description(productRequest.getDescription())
      .price(productRequest.getPrice())
      .images(productRequest.getImages())
      .build();


      Integer categoryId = productRequest.getCategoryId();

      Category category =  categoryRepository.findById(categoryId).orElse(null);
      if(category!=null)
      {
      return productRepository.save(product);
      }
      else{
          throw new CategoryNotFoundException("Catergory Not Found Exception");
      }
}

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public List<Product> getAllProductsByCategory(String categoryname) {
  List<Product> getAllProductsByCategory = productRepository.findByCategoryName(categoryname).orElse(new ArrayList<Product>());
  
  if(getAllProductsByCategory!=null)
  {
    return getAllProductsByCategory;
  }
  else
  {
    throw new CategoryNotFoundException("Category not Found Exception");
  }
  
  
    }

  public Product updateProduct(ProductRequest productRequest) {

     Product product = Product.builder()
      .categoryId(productRequest.getCategoryId())
      .title(productRequest.getTitle())
      .description(productRequest.getDescription())
      .price(productRequest.getPrice())
      .images(productRequest.getImages())
      .build();

      Product product2 = productRepository.findById(product.getId()).orElse(product);

      return productRepository.save(product2);
  }

  public Product deleteProduct(ProductRequest productRequest) {
    return productRepository.deleteByTitle(productRequest.getTitle()).orElse(new Product());
  }

  public List<Product> getsortedAllProducts(String sortedkey) {
    return productRepository.findAll(Sort.by(sortedkey).descending());
  }

  public Product checkProduct(String productname) {
    return productRepository.findByTitle(productname).orElse(new Product());
  }

}
