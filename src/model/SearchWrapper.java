package model;

import java.util.List;

public class SearchWrapper {

    private List<Item> Items;

    public List<Item> getCategory() {
        return Items;
    }

    public void setCategory(List<Item> category) {
        this.Items = category;
    }
}
