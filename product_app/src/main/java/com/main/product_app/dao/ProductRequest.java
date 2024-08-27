package com.main.product_app.dao;

import java.util.List;
import com.main.product_app.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
  
  private int id;
  private int price;
  private String description;
  private List<Image> images;
  private int categoryId;
  private String title;
}
