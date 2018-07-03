package client;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;
import java.io.IOException;
import model.Currency;

public class CurrencyHandler {

    private final Meli meli;

    private static final CurrencyHandler instance = new CurrencyHandler();

    private CurrencyHandler() {
        meli = new Meli(11111L, "clientSecret");
    }

    public static CurrencyHandler getInstance() {
        return instance;
    }

    public Currency getCurrencies(String currencyid) throws MeliException {
        Currency currencies = null;
        try {
            final Response response = meli.get("/currencies/" + currencyid);
            final Gson gson = new Gson();
            currencies = gson.fromJson(response.getResponseBody(), Currency.class);
        } catch (MeliException ex) {
            System.out.println("Error " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return currencies;
    }

    public Double fromUSD(String Currency, Double amount) {
        Convertion conversionratios = null;
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://api.mercadolibre.com/currency_conversions/search?from=USD&to=" + Currency).
                    header("accept", "application/json").
                    queryString("query", "desc").asJson();
            String jsonimported = response.getBody().toString();
            final Gson gson = new Gson();
            conversionratios = gson.fromJson(jsonimported, Convertion.class);
        } catch (UnirestException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return amount * conversionratios.getRatio();

    }

    public Double toUSD(String Currency, Double amount) {
        Convertion conversionratios = null;
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://api.mercadolibre.com/currency_conversions/search?from=USD&to=" + Currency).
                    header("accept", "application/json").
                    queryString("query", "desc").asJson();
            String jsonimported = response.getBody().toString();
            final Gson gson = new Gson();
            conversionratios = gson.fromJson(jsonimported, Convertion.class);
        } catch (UnirestException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return amount / conversionratios.getRatio();
    }

    public String getCurrencyID(String site) {
        if (site.equals("MLU")) {
            return "UYU";
        } else if (site.equals("MLB")) {
            return "BRL";
        } else if (site.equals("MLC")) {
            return "CLP";
        } else if (site.equals("MLA")) {
            return "ARS";
        } else if (site.equals("MCO")) {
            return "COP";
        } else if (site.equals("MLM")) {
            return "MXN";
        } else if (site.equals("MPE")) {
            return "PEN";
        } else if (site.equals("MLV")) {
            return "VEF";
        } else if (site.equals("MEC")) {
            return "USD";
        }
        return "error";
    }

    private static class Convertion {

        Double ratio;
        Double mercadopago_ratio;

        public Double getRatio() {
            return ratio;
        }

        public void setRatio(Double ratio) {
            this.ratio = ratio;
        }

        public Double getMercadopago_ratio() {
            return mercadopago_ratio;
        }

        public void setMercadopago_ratio(Double mercadopago_ratio) {
            this.mercadopago_ratio = mercadopago_ratio;
        }

        public Convertion(Double ratio, Double mercadopago_ratio) {
            this.ratio = ratio;
            this.mercadopago_ratio = mercadopago_ratio;
        }

        public Convertion() {
        }
    }

}
