package model;

public class Item {

    private String id;
    private String site_id;
    private String title;
    private String category_id;
    private Double price;
    private String currency_id;
    private String seller_id;
    private Integer sold_quantity;
    private String buying_mode;
    private String listing_type_id;
    private String condition;
    private String thumbnail;
    private String permalink;

    public Item(Double price, String currency_id) {
        this.price = price;
        this.currency_id = currency_id;
    }

    public Item(String itemid, String site, String titulo, String category, String currency, String seller, String buyingmode, String listing, Double precio, Integer sold, String condicion, String thumbnail, String permalink) {
        this.id = itemid;
        this.site_id = site;
        this.title = titulo;
        this.category_id = category;
        this.price = precio;
        this.currency_id = currency;
        this.seller_id = seller;
        this.sold_quantity = sold;
        this.buying_mode = buyingmode;
        this.listing_type_id = listing;
        this.condition = condicion;
        this.thumbnail = thumbnail;
        this.permalink = permalink;
    }

    public String getCondition() {
        return condition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(Integer sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getBuying_mode() {
        return buying_mode;
    }

    public void setBuying_mode(String buying_mode) {
        this.buying_mode = buying_mode;
    }

    public String getListing_type_id() {
        return listing_type_id;
    }

    public void setListing_type_id(String listing_type_id) {
        this.listing_type_id = listing_type_id;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPermalink() {
        return permalink;
    }

}
