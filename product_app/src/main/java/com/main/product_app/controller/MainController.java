package com.main.product_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.product_app.dao.CategoryRequest;
import com.main.product_app.dao.ProductRequest;
import com.main.product_app.entity.Category;
import com.main.product_app.entity.Product;
import com.main.product_app.service.CategoryService;
import com.main.product_app.service.ProductService;

@RestController
@RequestMapping("/api/v1/operation")
public class MainController {
  
  @Autowired
  private ProductService productService;

  @Autowired
  private CategoryService categoryService;

  @PostMapping("/product/insert")
  public Product InsertProducts(@RequestBody ProductRequest productRequest) throws Exception
  {
    return productService.InsertProducts(productRequest);
  }

  @PostMapping("/product/{productname}")
  public Product checkProduct(@PathVariable String productname)
  {
    return productService.checkProduct(productname);
  }

  @PostMapping("/category/insert")
  public Category InsertCategory(@RequestBody CategoryRequest categoryRequest)
  {
    return categoryService.InsertCategory(categoryRequest);
  }

  @GetMapping("/category/getall")
  public List<String> GetAllCategory()
  {

    return categoryService.GetAllCategory();
  }

  @GetMapping("/product/getall")
  public List<Product> getAllProducts()
  {
    return productService.getAllProducts();
  }

  @GetMapping("/product/getall/{categoryname}")
  public List<Product> getAllProductsByCategory(@PathVariable String categoryname)
  {
    return productService.getAllProductsByCategory(categoryname);
  }
  
  @PutMapping("/product/update")
  public Product updateProduct(@RequestBody ProductRequest productRequest)
  {
    return productService.updateProduct(productRequest);
  }

  @PutMapping("/category/update")
  public Category updateCategory(@RequestBody CategoryRequest categoryRequest)
  {
    return categoryService.updateCategory(categoryRequest);
  }

  @DeleteMapping("/product/delete/{name}")
  public Product deleteProduct(@RequestBody ProductRequest productRequest)
  {
    return productService.deleteProduct(productRequest);
  }

  @DeleteMapping("/category/delete/{name}")
  public Category deleteCategory(@RequestBody CategoryRequest categoryRequest)
  {
    return categoryService.deleteCategory(categoryRequest);
  }


  @GetMapping("/product/getall/sorted/{sortedkey}")
  public List<Product> getsortedAllProducts(@PathVariable String sortedkey)
  {
    return productService.getsortedAllProducts(sortedkey);
  }

  

}
