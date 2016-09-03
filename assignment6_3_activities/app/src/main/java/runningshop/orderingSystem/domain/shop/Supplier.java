package runningshop.orderingSystem.domain.shop;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import runningshop.orderingSystem.domain.address.AddressVO;

/**
 * Created by Siraaj on 04/16/2016.
 */
public class Supplier implements Serializable,ISupplierEvents {
    Long supplierID;
    String supplierName;
    AddressVO supplierAddress;
    DateFormat dateFormat;
    Date date;
    Map<Long,Date> supplierEventHistory = new HashMap();

    public Supplier(BuilderSupplier builderSupplier){
        supplierID = builderSupplier.supplierID;
        supplierName = builderSupplier.supplierName;
        supplierAddress = builderSupplier.supplierAddress;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        SupplierAdded();

    }


    public Long getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public AddressVO getSupplierAddress() {
        return supplierAddress;
    }

    public String getPostalCode(){
        return supplierAddress.getPostalCode();
    }

    public String getStreetName(){
        return supplierAddress.getStreetName();
    }

    public String getSuburb(){
        return supplierAddress.getSuburb();
    }

    public void viewSupplier(){
        System.out.println("Supplier ID: "+supplierID);
        System.out.println("Supplier Name: "+supplierName);
        System.out.println("Supplier Address");
        supplierAddress.viewAddress();
    }

    @Override
    public void SupplierAdded() {
        supplierEventHistory.put(supplierID,date);
    }

    @Override
    public void viewSupplierHistory(Long supplierID) {
        if(!supplierEventHistory.get(supplierID).equals(null)) {
            System.out.println("Partners since");
            System.out.println(supplierEventHistory.get(supplierID));
            System.out.println("With: "+supplierName);
        }
    }


    //builder
    public static class BuilderSupplier{
        Long supplierID;
        String supplierName;
        AddressVO supplierAddress;

        public BuilderSupplier supplierID(Long supplierID){
            this.supplierID = supplierID;
            return this;
        }

        public BuilderSupplier supplierName(String supplierName){
            this.supplierName = supplierName;
            return this;
        }

        public BuilderSupplier supplierAddress(AddressVO  supplierAddress){
            this.supplierAddress = supplierAddress;
            return this;
        }

        public BuilderSupplier copy(Supplier supplier){
            this.supplierID = supplier.supplierID;
            this.supplierName = supplier.supplierName;
            this.supplierAddress = supplier.supplierAddress;
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }


    }
}
