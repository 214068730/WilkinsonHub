package runningshop.assignment6.domain.shop;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siraaj on 04/14/2016.
 */
public class Item implements Serializable,IItemEvents {
    String itemCode;
    String itemName;
    DateFormat dateFormat;
    Date date;
    Map<String,Date> itemEventHistory = new HashMap();


    public Item(ItemBuilder itemBuilder) {
        this.itemCode = itemBuilder.itemCode;
        this.itemName = itemBuilder.itemName;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        ItemAriived();
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
                "itemCode='" + itemCode + '\'' +", itemName='" + itemName;
    }

    @Override
    public void ItemAriived() {
        itemEventHistory.put(itemCode,date);
    }

    public void viewItemHistory(String itemCode) {
        if (!itemEventHistory.get(itemCode).equals(null)) {
            System.out.println("Item arrived on");
            System.out.println(itemEventHistory.get(itemCode));
            System.out.println("By: " + itemName);

        }
    }

    public static class ItemBuilder{
        String itemCode;
        String itemName;
        DateFormat dateFormat;
        Date date;

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
