package application.handler;

import application.data.OutputData;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler implements DataHandler<Object> {

    JSONParser parser;

    public FileHandler(JSONParser parser){
        this.parser=parser;
    }


    @Override
    public void writeToFile(String data, String filepath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode=mapper.readTree(data);
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File(filepath), jsonNode);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String convertOutputToJson(ArrayList<OutputData> dataList) {
        return null;
    }

    @Override
    public <T extends Object> T  parse(Object data) {
        T genericDataHolder = null;

        try {
            genericDataHolder = (T) parser.parse(new FileReader((String)data));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return genericDataHolder;
        }
    }
}
