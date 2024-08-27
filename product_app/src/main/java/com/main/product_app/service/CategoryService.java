package com.main.product_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.product_app.dao.CategoryRequest;
import com.main.product_app.entity.Category;
import com.main.product_app.entity.Product;
import com.main.product_app.exception.CategoryAlreadyExistsException;
import com.main.product_app.repository.CategoryRepository;
import com.main.product_app.repository.ProductRepository;

@Service
public class CategoryService {
  
  
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  public Category InsertCategory(CategoryRequest categoryRequest)
  {

      Category category = Category.builder()
      .name(categoryRequest.getName())
      .image(categoryRequest.getImage())
      .build();

      try
      {
      return categoryRepository.save(category);
      }
      catch(Exception e)
      {
        int categoryId = categoryRepository.findByName(category.getName()).getId();
          throw new CategoryAlreadyExistsException("Category Already Exists at "+categoryId );
      }
     
  }

    public List<String> GetAllCategory() {
    return categoryRepository.GetAllCategory();

  }

    public Category updateCategory(CategoryRequest categoryRequest) {
      
      Category category = Category.builder()
      .id(categoryRequest.getId())
      .name(categoryRequest.getName())
      .image(categoryRequest.getImage())
      .build();

      Category category2 = categoryRepository.findById(category.getId()).orElse(category);

      return categoryRepository.save(category2);
    }

    public Category deleteCategory(CategoryRequest categoryRequest) {
      return categoryRepository.deleteByName(categoryRequest.getName()).orElse(new Category());
    }
}
