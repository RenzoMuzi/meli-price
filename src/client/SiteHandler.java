package client;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;
import model.Site;
import model.User;

public class SiteHandler {

    private static final String ID_KEY = "title";
    private static final String NAME_KEY = "query";
    private final Meli meli;

    private static final SiteHandler instance = new SiteHandler();

    private SiteHandler() {
        meli = new Meli(11111L, "clientSecret");
    }

    public static SiteHandler getInstance() {
        return instance;
    }

    public User getUser(String custid) throws MeliException {
        User nuevoUser = null;
        try {
            final Response response = meli.get("/users/" + custid);
            final Gson gson = new Gson();
            System.out.println(response.getResponseBody());
            nuevoUser = gson.fromJson(response.getResponseBody(), User.class);

        } catch (MeliException ex) {
            System.out.println("Error " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return nuevoUser;
    }
}
