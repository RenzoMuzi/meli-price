package client;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;
import model.Site;
import model.User;
import model.Item;

public class ItemHandler {

    private final Meli meli;

    private static final ItemHandler instance = new ItemHandler();

    private ItemHandler() {
        meli = new Meli(11111L, "clientSecret");
    }

    public static ItemHandler getInstance() {
        return instance;
    }

    public Item getItem(String itemID) throws MeliException {
        Item nuevoItem = null;
        try {
            final Response response = meli.get("/items/" + itemID);
            final Gson gson = new Gson();
            nuevoItem = gson.fromJson(response.getResponseBody(), Item.class);

        } catch (MeliException ex) {
            System.out.println("Error " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return nuevoItem;
    }
}
