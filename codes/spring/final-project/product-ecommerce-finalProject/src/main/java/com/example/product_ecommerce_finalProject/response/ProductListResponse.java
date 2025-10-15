package com.example.product_ecommerce_finalProject.response;

import java.util.List;

import com.example.product_ecommerce_finalProject.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {
private List<Product> products;
}
