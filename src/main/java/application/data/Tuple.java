package application.data;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by jacob on 6/15/17.
 */
public  class Tuple{
    String prodTitle;
    public Tuple(){
        answers=new TreeMap<>();
    }
    public TreeMap<String, HashMap<String, List<Listings>>> answers;


    public String getProdTitle() {
        return prodTitle;
    }

    public void setAnswers(TreeMap<String, HashMap<String, List<Listings>>> answers) {
        this.answers = answers;
    }

    public String getProduct() {
        return prodTitle;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public TreeMap<String, HashMap<String, List<Listings>>> getAnswers() {
        return answers;
    }

}