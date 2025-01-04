package com.productlist.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productlist.entity.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Integer>{

}
