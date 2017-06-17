package application;


import application.data.Product;
import application.data.Tuple;

import java.util.ArrayList;




/**
 * Created by jacob on 6/13/17.
 */
public class MainClass {

    public static ArrayList<Product> originalProducts;
    static ArrayList<Tuple> tupleList;

    static final String PRODUCTPATH="/Users/jacob/Downloads/challenge_data_20110429/products.txt";
    static final String LISTINGSPATH="/Users/jacob/Downloads/challenge_data_20110429/listings.txt";

    public static void runApplication(String path){
       Application.run(PRODUCTPATH,LISTINGSPATH,path);
    }
    public static void main(String[] args) {

        runApplication(args[0]);
    }





}



