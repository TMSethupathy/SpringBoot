package com.storeproject.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.storeproject.entity.Store;
import jakarta.transaction.Transactional;

@Repository
public interface StoreRepo extends JpaRepository<Store, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO store(product_name, product_quantity) VALUES(:productName, :productQuantity)", nativeQuery = true)
    void insertData(String productName, long productQuantity);

    @Transactional
    @Query("SELECT s FROM Store s")
    List<Store> getStore();

    @Modifying
    @Transactional
    @Query(value = "UPDATE store SET product_quantity = product_quantity - :quantity WHERE store_id = :storeId", nativeQuery = true)
    void decreaseProductQuantity(int storeId, long quantity);

    @Modifying
    @Transactional
    @Query(value = "UPDATE store SET product_quantity = product_quantity + " +
            "(CASE WHEN :operation = 'increase' THEN :quantity " +
            "WHEN :operation = 'decrease' THEN -:quantity " +
            "ELSE 0 END) WHERE store_id = :storeId", nativeQuery = true)
    void updateProductQuantity(int storeId, long quantity, String operation);
}
