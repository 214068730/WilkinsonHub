package com.assignment5.shop;

/**
 * Created by student on 2016/03/31.
 */
public class Item {
    String itemCode;
    String itemName;

    public Item(ItemBuilder itemBuilder) {
        this.itemCode = itemBuilder.itemCode;
        this.itemName = itemBuilder.itemName;
    }

    public String getItemCode() {
        return itemCode;
    }
    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName;
    }

    public static class ItemBuilder{
        String itemCode;
        String itemName;

        public ItemBuilder itemCode(String itemCode){
            this.itemCode = itemCode;
            return this;
        }

        public ItemBuilder itemName(String itemName){
            this.itemName = itemName;
            return this;
        }

        public ItemBuilder copy(Item item){
            this.itemCode = item.itemCode;
            this.itemName = item.itemName;
            return this;
        }

        public Item build(){
            return new Item(this);
        }
    }
}
