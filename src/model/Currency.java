package model;

public class Currency {

    String id;
    String symbol;
    String description;
    Integer decimal_places;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDecimal_places() {
        return decimal_places;
    }

    public void setDecimal_places(Integer decimal_places) {
        this.decimal_places = decimal_places;
    }

    public Currency(String id, String symbol, String description, Integer decimal_places) {
        this.id = id;
        this.symbol = symbol;
        this.description = description;
        this.decimal_places = decimal_places;
    }

}
