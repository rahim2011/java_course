package com.example.product_ecommerce_finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_ecommerce_finalProject.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByUserId(Integer id);

	List<Product> findAllByOrderByPriceAsc();

	List<Product> findAllByOrderByPriceDesc();

}