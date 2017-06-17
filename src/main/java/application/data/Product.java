package application.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by jacob on 6/13/17.
 */
public class Product  {
    private String productName;
    private String manufacturer;
    private String model;
    private String announcedDate;
    private String family;

    private String originalTitle;

    public Product(){

    }

    public void  setOriginalTitle(String originalTitle){
        this.originalTitle=originalTitle;
    }

    public String getOriginalTitle(){
        return originalTitle;
    }



    public Product copy(Product product){
        Product p=new Product();
        p.setOriginalTitle(product.getOriginalTitle());
        p.setProductName(product.getProductName());
        p.setAnnouncedDate(product.getAnnouncedDate());
        p.setFamily(product.getFamily());
        p.setManufacturer(product.getManufacturer());
        p.setModel(product.getModel());
        return p;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @JsonGetter("announced-date")
    public String getAnnouncedDate() {
        return announcedDate;
    }

    @JsonSetter("announced-date")
    public void setAnnouncedDate(String announcedDate) {
        this.announcedDate = announcedDate;
    }

    @JsonGetter("product_name")
    public String getProductName() {
        return productName;
    }

    @JsonSetter("product_name")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "application.data.Product{" +
                "productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", announcedDate='" + announcedDate + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}
