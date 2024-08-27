package com.main.product_app.dao;

import java.util.List;

import com.main.product_app.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {

  private int id;
  private String name;
  private String image;
}
