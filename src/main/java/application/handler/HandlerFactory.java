package application.handler;

import org.json.simple.parser.JSONParser;

/**
 * Created by jacob on 6/16/17.
 */
public class HandlerFactory {

    public static DataHandler createHander(String type){
        if(type.equals("json")){
            return new JsonHandler();
        }else if(type.equals("file")){
            JSONParser parser=new JSONParser();
            return new FileHandler(parser);
        }else{
            return null;
        }

    }
}
