package application.data;

/**
 * Created by jacob on 6/13/17.
 */
public class Listings {
    private String title;
    private String manufacturer;
    private String currency;
    private String price;


    public Listings() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "application.data.Listings{" +
                "title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", currency='" + currency + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result=17;
        result= 31 * result + title.hashCode();
        result= 31 * result + manufacturer.hashCode();
        result= 31 * result + currency.hashCode();
        result= 31 * result + price.hashCode();
        return result;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(!(obj instanceof Listings)){
            return false;
        }

        Listings listings=(Listings) obj;
        return  listings.title.equals(title) &&
                listings.manufacturer.equals(manufacturer) &&
                listings.currency.equals(currency) &&
                listings.price.equals(price);

    }
}
