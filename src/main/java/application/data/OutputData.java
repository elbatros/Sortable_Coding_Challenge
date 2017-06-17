package application.data;

import java.util.ArrayList;

/**
 * Created by jacob on 6/17/17.
 */
public class OutputData {
    private String product_name;
    private ArrayList<String> listings;

    public OutputData() {
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public ArrayList<String> getListings() {
        return listings;
    }

    public void setListings(ArrayList<String> listings) {
        this.listings = listings;
    }
}
