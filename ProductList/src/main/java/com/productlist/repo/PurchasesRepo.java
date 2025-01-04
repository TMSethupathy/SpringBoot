package com.productlist.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productlist.entity.Purchases;

@Repository
public interface PurchasesRepo extends JpaRepository<Purchases,Integer>{

	  Optional<Purchases> findByPurchaseId(Integer purchaseId);

}
