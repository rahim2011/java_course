package com.example.product_ecommerce_finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_ecommerce_finalProject.entity.Order;



public interface OrderRepository extends JpaRepository<Order, Integer> {

}