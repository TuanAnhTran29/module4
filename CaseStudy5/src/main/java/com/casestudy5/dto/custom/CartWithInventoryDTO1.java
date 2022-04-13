package com.casestudy5.dto.custom;


public class CartWithInventoryDTO1 {
    Long cartId;
    int quantity;
    Long productId;
    int inventory;

    public CartWithInventoryDTO1(Long cartId, int quantity, Long productId, int inventory) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.productId = productId;
        this.inventory = inventory;
    }

    public CartWithInventoryDTO1() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
