package com.main.product_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.main.product_app.entity.Category;
import com.main.product_app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

  @Query(nativeQuery = true,value = "select * from product where category_id = (select id from category where name = ?1)")
  public Optional<List<Product>> findByCategoryName(String categoryname);

  public Optional<Product> deleteByTitle(String title);

  public Optional<Product> findByTitle(String productname);
  
}
