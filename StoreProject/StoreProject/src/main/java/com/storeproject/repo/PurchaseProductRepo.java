package com.storeproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.storeproject.entity.PurchaseProduct;
import jakarta.transaction.Transactional;

@Repository
public interface PurchaseProductRepo extends JpaRepository<PurchaseProduct, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO purchase_product(purchase_product_name, purchase_product_quantity, store_id) VALUES(:purchaseProductName, :purchaseProductQuantity, :storeId)", nativeQuery = true)
    void insertPurchaseProduct(String purchaseProductName, long purchaseProductQuantity, int storeId);

    @Query("SELECT p FROM PurchaseProduct p")
    List<PurchaseProduct> findAllPurchaseProducts();

    // Update purchase product's name and quantity
    @Modifying
    @Transactional
    @Query(value = "UPDATE purchase_product SET purchase_product_name = :purchaseProductName, " +
            "purchase_product_quantity = :purchaseProductQuantity " +
            "WHERE purchase_id = :purchaseId", nativeQuery = true)
    void updatePurchaseProduct(int purchaseId, String purchaseProductName, long purchaseProductQuantity);
}
