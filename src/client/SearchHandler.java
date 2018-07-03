package client;

import app.PriceFrame;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Data;
import model.Item;
import model.Search;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchHandler {

    private final Meli meli;

    private static final SearchHandler instance = new SearchHandler();

    private SearchHandler() {
        meli = new Meli(11111L, "clientSecret");
    }

    public static SearchHandler getInstance() {
        return instance;
    }

    public Search getSearchwithUnirest(String query, String Siteid, String condicion, String min, String max, boolean publicadoHoy) {
        Search newsearch = null;
        try {
            String queryfinal = query.replaceAll(" ", "+");
            HttpResponse<JsonNode> response = null;
            
            String url="https://api.mercadolibre.com/sites/" + Siteid + "/search?q=" + queryfinal + "&condition=" + condicion;
            
            if(publicadoHoy)
                url=url+"&since=today";
            
            if(min.equals("*") && max.equals("*")){
            response = Unirest.get(url).
                    header("accept", "application/json").queryString("query", "desc").asJson();
            }
            else{
                System.out.println(url+"&price="+min+"-"+max);
                response = Unirest.get(url+"&price="+min+"-"+max).
                    header("accept", "application/json").queryString("query", "desc").asJson();
            }
            String jsonimported = response.getBody().toString();
            final Gson gson = new Gson();
            newsearch = gson.fromJson(jsonimported, Search.class);
        } catch (UnirestException ex) {
            Logger.getLogger(SearchHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newsearch;
    }
}
