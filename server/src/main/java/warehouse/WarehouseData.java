package warehouse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class WarehouseData implements Serializable {

    private String id;
    private String name;
    private String timestamp;
    private String street;
    private String city;
    private String country;
    private String plz;

    private ArrayList<Product> productData;


    public WarehouseData() {

        int r = new Random().nextInt(6) + 4;
        productData = new ArrayList<Product>(r);

        for(int i = 0; i < r; i++) {
            productData.add(new Product());
        }

        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

    }


    public ArrayList<Product> getProductData() {
        return this.productData;
    }

    public void setProductData(ArrayList<Product> productData) {
        this.productData = productData;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }


    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPlz() {
        return this.plz;
    }


    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(this.id).append("\n");
        sb.append("Name: ").append(this.name).append("\n");
        sb.append("Timestamp: ").append(this.timestamp).append("\n");
        sb.append("Street: ").append(this.street).append("\n");
        sb.append("City: ").append(this.city).append("\n");
        sb.append("Country: ").append(this.country).append("\n");
        sb.append("PLZ: ").append(this.plz).append("\n");
        sb.append("Products: \n");

        for(Product p : this.productData){
            sb.append(p.toString()).append("\n");
        }

        return sb.toString();
    }
}