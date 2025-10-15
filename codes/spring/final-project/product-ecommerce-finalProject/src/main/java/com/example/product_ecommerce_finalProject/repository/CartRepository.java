package com.example.product_ecommerce_finalProject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_ecommerce_finalProject.entity.Cart;



public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findAllByUserId(Integer id);

}