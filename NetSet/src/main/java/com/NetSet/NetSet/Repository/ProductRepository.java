package com.NetSet.NetSet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NetSet.NetSet.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
