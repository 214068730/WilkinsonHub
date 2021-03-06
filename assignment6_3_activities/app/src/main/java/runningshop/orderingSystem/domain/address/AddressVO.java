package runningshop.orderingSystem.domain.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Siraaj on 04/16/2016.
 */
public class AddressVO  implements Serializable{
    @JsonProperty("postalCode")
    String postalCode;
    @JsonProperty("streetName")
    String streetName;
    @JsonProperty("suburb")
    String suburb;


    private AddressVO(){}

    public AddressVO(AddressBuilder address){
        this.postalCode = address.postalCode;
        this.streetName = address.streetName;
        this.suburb = address.suburb;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void viewAddress(){
        System.out.println(postalCode);
        System.out.println(streetName);
        System.out.println(suburb);
    }

    /*Create builder*/
    public static class AddressBuilder{
        String postalCode;
        String streetName;
        String suburb;

        public AddressBuilder postalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder streetName(String streetName){
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder suburb(String suburb){
            this.suburb = suburb;
            return this;
        }

        public AddressBuilder copy(AddressVO address){
            this.postalCode = address.postalCode;
            this.streetName = address.streetName;
            this.suburb = address.suburb;
            return this;
        }

        public AddressVO build(){
            return new AddressVO(this);
        }
    }

}
