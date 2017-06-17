package application;

import application.data.Listings;
import application.data.OutputData;
import application.data.Product;
import application.data.Tuple;
import application.handler.DataHandler;
import application.handler.HandlerFactory;
import application.handler.JsonHandler;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jacob on 6/16/17.
 */
public class Application {


    static DataHandler fileHandler;
    static DataHandler jsonHandler;
    static DataProcessor dataProcessor;
    public static void run(String productFile, String listingFile, String outputPath){

        Object prodFileData=readFileData(productFile,"file");
        Object listFileData=readFileData(listingFile,"file");

        JSONArray productJson=convertToJson(prodFileData);
        JSONArray listJson=convertToJson(listFileData);

        try {
            ArrayList<Product> productList= JsonHandler.convertJsonToObject(productJson,true,false);
            ArrayList<Listings> listingsArrayList=JsonHandler.convertJsonToObject(listJson,false,true);
            ArrayList<Tuple> result=filterData(productList,listingsArrayList);
            jsonHandler=HandlerFactory.createHander("json");
            String json=jsonHandler.convertOutputToJson(storeToMap(result));
            fileHandler.writeToFile(json,outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){

        }



        System.out.println();
    }

     static ArrayList<Tuple> filterData(ArrayList<Product> products, ArrayList<Listings> listings){
        dataProcessor=new DataProcessor();
        dataProcessor.filterListingsByManufacturer(listings);
        dataProcessor.filterProductByManufacturer(products);
        ArrayList<Tuple> results=dataProcessor.getListingsForProduct();
        return results;

     }

    public static ArrayList<OutputData> storeToMap(ArrayList<Tuple> results) {
         ArrayList<OutputData> dataMap=new ArrayList<>();
        for(Tuple tuple: results){
            OutputData data=new OutputData();
            data.setProduct_name(tuple.getProdTitle());
            data.setListings(new ArrayList<>());
            for(String l: tuple.answers.keySet()){
                for(String i: tuple.answers.get(l).keySet()){
                    for(Listings listings: tuple.answers.get(l).get(i)){
                        listings.setTitle(listings.getTitle().replaceAll("_"," "));
                        data.getListings().add(listings.getTitle());

                    }
                }
            }
            dataMap.add(data);
        }

        return dataMap;


    }
     static Object readFileData(String prodFile, String type){
        fileHandler= HandlerFactory.createHander(type);

        return fileHandler.parse(prodFile);
    }

    static JSONArray convertToJson(Object rawData){
        return (JSONArray) rawData;
    }
}
