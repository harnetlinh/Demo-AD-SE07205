package com.example.se07205_b41;

public class Item {
    String name;
    int quantity;

    int unitPrice = 0;

    public Item(String name, int quantity) { // Hàm khởi tạo
        this.name = name;
        this.quantity = quantity;
    }

    public Item(String name, int quantity, int unitPrice){ // Hàm khởi tạo
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String toString(){
        return name + " - Số lượng: " + quantity + " - Đơn giá: " + unitPrice + " VNĐ";
    }

    public int getUniPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
