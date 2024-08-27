package com.main.product_app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.main.product_app.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

  Category findByName(String name);

  Optional<Category> deleteByName(String name);

   @Query(nativeQuery = true,value = "select name from category")
  public List<String> GetAllCategory();
  
}
