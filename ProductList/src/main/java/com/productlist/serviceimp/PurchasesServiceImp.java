package com.productlist.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productlist.dto.PurchasesDTO;
import com.productlist.entity.Products;
import com.productlist.entity.PurchaseItem;
import com.productlist.entity.Purchases;
import com.productlist.repo.ProductsRepo;
import com.productlist.repo.PurchasesRepo;
import com.productlist.service.PurchasesService;

@Component
public class PurchasesServiceImp implements PurchasesService {

    @Autowired
    private PurchasesRepo purchasesRepo;

    @Autowired
    private ProductsRepo productsRepo;

    @Override
    public void createPurchases(PurchasesDTO purchasesDto) {
        Purchases purchase = new Purchases();
        
        Purchases savedPurchase = purchasesRepo.save(purchase);

        List<PurchaseItem> purchaseItems = purchasesDto.getProductDTO().stream().map(itemDTO -> {
            Products product = productsRepo.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getQuantity() < itemDTO.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getProductId());
            }
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setProducts(product);
            purchaseItem.setQuantity(itemDTO.getQuantity());
            
            purchaseItem.setPurchase(savedPurchase);

            product.setQuantity(product.getQuantity() + itemDTO.getQuantity());
            productsRepo.save(product);

            return purchaseItem;
        }).collect(Collectors.toList());

        savedPurchase.setPurchaseItems(purchaseItems);

        purchasesRepo.save(savedPurchase);
    }

	@Override
	public List<PurchasesDTO> getAllPurchases() {
		List<Purchases> findAll = purchasesRepo.findAll();
		return findAll.stream().map(this::convertToDto).collect(Collectors.toList()) ;
		
	}

	private PurchasesDTO convertToDto(Purchases purchases) {
		PurchasesDTO purchasesDTO =new PurchasesDTO();
		
		purchasesDTO.setPurchaseId(purchases.getPurchaseId());
		purchasesDTO.setProductDTO(
				purchases.getPurchaseItems().stream().map(purchaseItem->{
			   
				PurchasesDTO.ProductDTO productDTO =new PurchasesDTO.ProductDTO();
				productDTO.setProductId(purchaseItem.getProducts().getProductId());
				productDTO.setProductName(purchaseItem.getProducts().getProductName());
				productDTO.setQuantity(purchaseItem.getQuantity());
				return productDTO;
				}).collect(Collectors.toList())
				);
		return purchasesDTO;
		
	}

	@Override
	public void editPurchase(int purchaseId, PurchasesDTO purchasesDto) {
		// TODO Auto-generated method stub
		
	}
}