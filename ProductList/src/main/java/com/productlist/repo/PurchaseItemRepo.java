package com.productlist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productlist.entity.PurchaseItem;

@Repository
public interface PurchaseItemRepo extends JpaRepository<PurchaseItem, Integer>{

}
