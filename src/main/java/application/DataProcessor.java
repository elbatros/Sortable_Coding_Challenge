package application;

import application.data.Listings;
import application.data.Product;
import application.data.Tuple;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;

import java.util.*;

/**
 * Created by jacob on 6/16/17.
 */
public class DataProcessor {

    ObjectMapper objectMapper = new ObjectMapper();

    Map<String, List<Product>> productList = new TreeMap<>();
    Map<String, List<Listings>> listingsList = new TreeMap<String, List<Listings>>();
    HashMap<Product, List<Listings>> finalResult = new HashMap<>();



    //TODO: check for parallel
    public void filterListingsByManufacturer( ArrayList<Listings> listings) {
        for (int i = 0; i < listings.size(); i++) {

            listings.get(i).setTitle(listings.get(i).getTitle().replaceAll("\\s+", "_").toLowerCase());
            listings.get(i).setManufacturer(listings.get(i).getManufacturer().toLowerCase());

            if (listingsList.containsKey(listings.get(i).getManufacturer())) {
                listingsList.get(listings.get(i).getManufacturer()).add(listings.get(i));
            } else {
                listingsList.put(listings.get(i).getManufacturer(), new ArrayList<Listings>());
                listingsList.get(listings.get(i).getManufacturer()).add(listings.get(i));

            }
        }
    }


    public void filterProductByManufacturer(ArrayList<Product> products){

        for (int i = 0; i < products.size(); i++) {
            products.get(i).setOriginalTitle(products.get(i).getProductName());
            products.get(i).setProductName(products.get(i).getProductName().replaceAll("\\s+", "_").toLowerCase());
            products.get(i).setManufacturer(products.get(i).getManufacturer().toLowerCase());

            if (productList.containsKey(products.get(i).getManufacturer())) {
                productList.get(products.get(i).getManufacturer()).add(products.get(i));
            } else {
                productList.put(products.get(i).getManufacturer(), new ArrayList<Product>());
                productList.get(products.get(i).getManufacturer()).add(products.get(i));

            }
        }


    }

    public ArrayList getListingsForProduct(){
        ArrayList<Listings> temp = new ArrayList<>();
         ArrayList<Tuple> tupleList=new ArrayList<>();

        ArrayList<Product> originalProducts= new ArrayList<>();
        for (String str : productList.keySet()) {
            if (listingsList.containsKey(str)) {

                for (Product p : productList.get(str)) {
                    Tuple t=new Tuple();
                    p.setModel(p.getModel().toLowerCase());

                    for (Listings l : listingsList.get(str)) {

                        if (l.getTitle().contains(p.getModel())) {
                            temp.add(l);
                        }
                    }
                    for (Listings listings1 : temp) {
                        if(!finalResult.containsKey(p)){
                            finalResult.put(p,new ArrayList<>());
                        }
                        HashSet<String> itersListing = new HashSet<>(FluentIterable.from(Splitter.on('_')
                                .trimResults()
                                .omitEmptyStrings()
                                .split(listings1.getTitle()))
                                .toSet());

                        String[] prodListing = FluentIterable.from(Splitter.on('_')
                                .trimResults()
                                .omitEmptyStrings()
                                .split(p.getProductName()))
                                .toArray(String.class);

                        //TODO:REFACTOR THE LOOP
                        if (itersListing.contains(prodListing[0])) {

                            if (t.answers.containsKey(prodListing[0])) {
                                if (itersListing.contains(prodListing[1])) {
                                    t.setProdTitle(p.getOriginalTitle());
                                    originalProducts.add(p);

                                    if (t.answers.get(prodListing[0]).containsKey(prodListing[1])) {
                                        t.answers.get(prodListing[0]).get(prodListing[1]).add(listings1);
                                    } else {
                                        t.answers.get(prodListing[0]).put(prodListing[1], new ArrayList<Listings>());
                                        t.answers.get(prodListing[0]).get(prodListing[1]).add(listings1);
                                    }
                                }
                            } else {
                                originalProducts.add(p);
                                t.setProdTitle(p.getOriginalTitle());

                                if (itersListing.contains(prodListing[1])) {
                                    t.answers.put(prodListing[0], new HashMap<>());
                                    t.answers.get(prodListing[0]).put(prodListing[1], new ArrayList<Listings>());
                                    t.answers.get(prodListing[0]).get(prodListing[1]).add(listings1);
                                }
                            }
                        }
                    }
                    temp.clear();
                    if(t.answers.keySet().size()>0){
                        tupleList.add(t);
                    }

                }


            }

        }
        return tupleList;

    }



    public Map<String, List<Product>> getProductList() {
        return productList;
    }

    public void setProductList(Map<String, List<Product>> productList) {
        this.productList = productList;
    }

    public Map<String, List<Listings>> getListingsList() {
        return listingsList;
    }

    public void setListingsList(Map<String, List<Listings>> listingsList) {
        this.listingsList = listingsList;
    }
}
