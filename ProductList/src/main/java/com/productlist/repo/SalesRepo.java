package com.productlist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productlist.entity.Sales;

@Repository
public interface SalesRepo extends JpaRepository<Sales,Integer>{

}
