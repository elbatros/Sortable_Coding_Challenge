package application.handler;

import application.data.OutputData;

import java.util.ArrayList;

/**
 * Created by jacob on 6/16/17.
 */
public interface  DataHandler<T> {

     void writeToFile(String data, String filepath);

     String convertOutputToJson(ArrayList<OutputData> dataList);

     <T> T parse(Object data);
}
