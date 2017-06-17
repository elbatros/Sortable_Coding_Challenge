package application.handler;

import application.data.Listings;
import application.data.OutputData;
import application.data.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 6/16/17.
 */
public class JsonHandler implements DataHandler<JSONArray>  {


    public JsonHandler(){
    }


    public static ArrayList convertJsonToObject(JSONArray jsonData, boolean isProduct, boolean isListings) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        if(isProduct) {
            ArrayList<Product> list = objectMapper.readValue(String.valueOf(jsonData), new TypeReference<List<Product>>() {});
            return list;
        }else if(isListings) {
            ArrayList<Listings> list = objectMapper.readValue(String.valueOf(jsonData), new TypeReference<List<Listings>>() {});
            return list;
        }else{
            throw new NullPointerException();
        }

    }

    @Override
    public void writeToFile(String data, String filepath) {}

    @Override
    public String convertOutputToJson(ArrayList<OutputData> dataList) {
        String json=new String();
        try {
            json=new ObjectMapper().writeValueAsString(dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return json;
        }
    }


    public <T> T parse(Object data) {
        return (T) data;
    }


}


