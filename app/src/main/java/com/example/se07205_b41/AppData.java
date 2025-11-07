package com.example.se07205_b41;

import java.util.ArrayList;

public class AppData {
    static String AppName = "My App";

    static ArrayList<String> TaskList = new ArrayList<String>();
    static ArrayList<Item> ItemList = new ArrayList<Item>();
    static int REQUEST_EDIT_TASK = 1;

    static int getTotalBill(){
        try {
            int totalBill = 0;
            for (int i = 0; i < ItemList.size(); i++) {
                totalBill += (ItemList.get(i).getQuantity() * ItemList.get(i).getUniPrice());
            }
            return totalBill;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
