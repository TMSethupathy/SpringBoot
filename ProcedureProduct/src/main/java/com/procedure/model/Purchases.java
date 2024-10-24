package com.procedure.model;

import java.util.ArrayList;
import java.util.List;

public class Purchases {

    private int purchaseId;
    private List<PurchaseItem> purchaseItems = new ArrayList<>(); 

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public List<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }
}
