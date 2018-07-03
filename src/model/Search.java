package model;

import app.PriceFrame;
import client.CurrencyHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.JCheckBox;

public class Search {

    private String site_id;
    private Paging paging;
    private String query;
    private ArrayList<Item> results;
    private List<Item> secondaryresults;
    private List<Item> relatedresults;
    private Sort sort;
    private List<Sort> available_sorts;
    private List<Filter> filters;

    public Search(ArrayList<Item> results) {
        this.results = results;
    }

    public Search(String site_id, Paging paging, String query, ArrayList<Item> results, List<Item> secondaryresults, List<Item> relatedresults, Sort sort, List<Sort> available_sorts, List<Filter> filters, List<Filter> available_filters) {
        this.site_id = site_id;
        this.paging = paging;
        this.query = query;
        this.results = results;
        this.secondaryresults = secondaryresults;
        this.relatedresults = relatedresults;
        this.sort = sort;
        this.available_sorts = available_sorts;
        this.filters = filters;
        this.available_filters = available_filters;
    }
    private List<Filter> available_filters;

    public Search(String site_id, Paging paging, String query, ArrayList<Item> results) {
        this.site_id = site_id;
        this.paging = paging;
        this.query = query;
        this.results = results;
    }

    public String getQuery() {
        return query;
    }

    public String getSiteid() {
        return this.site_id;
    }

    public Integer getTotalItems() {
        return this.paging.getTotal();
    }

    public ArrayList<Item> getItemList() {
        return this.results;
    }

    public Double getPromedioenUSD(String Site, JCheckBox[] checks) {
        Double retu = getPromedio(Site, checks);
        Double retu2 = CurrencyHandler.getInstance().toUSD(CurrencyHandler.getInstance().getCurrencyID(Site), retu);
        retu2 = Math.floor(retu2 * 100) / 100;
        return retu2;
    }

    public Double getMinimo(String Site, JCheckBox[] checks) {
        Double minActual = Double.MAX_VALUE;
        Double aux;

        for (int i = 0; i < results.size(); i++) {
            if (checks[i].isSelected()) {
                if (results.get(i).getCurrency_id().equals("USD")) {
                    aux = CurrencyHandler.getInstance().fromUSD(CurrencyHandler.getInstance().getCurrencyID(Site), results.get(i).getPrice());
                } else {
                    aux = results.get(i).getPrice();
                };

                if (aux < minActual) {
                    minActual = aux;
                }
            }
        }
        return minActual;
    }

    public Double getMaximo(String Site, JCheckBox[] checks) {
        Double max = 0.0;
        Double aux;
        for (int i = 0; i < results.size(); i++) {
            if (checks[i].isSelected()) {
                if (results.get(i).getCurrency_id().equals("USD")) {
                    aux = CurrencyHandler.getInstance().fromUSD(CurrencyHandler.getInstance().getCurrencyID(Site), results.get(i).getPrice());
                } else {
                    aux = results.get(i).getPrice();
                };
                if (aux > max) {
                    max = aux;
                }
            }
        }
        return max;
    }

    public double getMediana(String Site, JCheckBox[] checks) {
        Double mediana = 0.0;
        Double aux;
        Double numeros[];
        numeros = new Double[50];
        int posicionNumeros = 0;

        for (int i = 0; i < results.size(); i++) {
            if (checks[i].isSelected()) {
                if (results.get(i).getCurrency_id().equals("USD")) {
                    aux = CurrencyHandler.getInstance().fromUSD(CurrencyHandler.getInstance().getCurrencyID(Site), results.get(i).getPrice());
                } else {
                    aux = results.get(i).getPrice();
                }
                numeros[posicionNumeros] = aux;
                posicionNumeros++;
            }
        }
        Arrays.sort(numeros, 0, posicionNumeros - 1);

        int largoNumeros = posicionNumeros - 1;

        if ((largoNumeros + 1) % 2 == 0) {
            mediana = (numeros[(int) (largoNumeros / 2)] + numeros[(int) (largoNumeros / 2) + 1]) / 2;
        } else {
            if ((largoNumeros + 1) == 1) {
                mediana = numeros[largoNumeros];
            } else {
                if ((largoNumeros + 1) % 2 == 1) {
                    mediana = (numeros[(int) (largoNumeros / 2) - 1]);
                }
            }
        }
        return mediana;
    }

    public Double getPromedio(String Site, JCheckBox[] checks) {
        Double Promedio = 0.0;
        Double SumaTotalUSD = 0.0;
        Double SumaTotalMoneda = 0.0;
        Integer Count = 0, CountUSD = 0, CountMoneda = 0;
        Double PromedioUSD = 0.0;
        Integer max = results.size();
        for (int i = 0; i < results.size(); i++) {
            if (checks[i].isSelected()) {
                if (results.get(i).getCurrency_id().equals("USD")) {
                    SumaTotalUSD = SumaTotalUSD + results.get(i).getPrice();
                    CountUSD++;
                } else {
                    SumaTotalMoneda = SumaTotalMoneda + results.get(i).getPrice();
                    CountMoneda++;
                }

                Count++;
            }
        }
        if (Site.equals("MLV")) {
            Promedio = SumaTotalMoneda;
        } else {
            Promedio = SumaTotalMoneda + CurrencyHandler.getInstance().fromUSD(CurrencyHandler.getInstance().getCurrencyID(Site), SumaTotalUSD);
        }
        Promedio = Promedio / Count;
        Promedio = Math.floor(Promedio * 100) / 100;
        return Promedio;
    }

    private static class Paging {

        Integer total;
        Integer offset;
        Integer limit;

        public Paging() {
        }

        public Integer getTotal() {
            return total;
        }
    }

    private static class Sort {

        String id;
        String name;

        public Sort(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Sort() {
        }
    }

    public static class Filter {

        public Filter(String id, String name, String type, List<Value> values) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.values = values;
        }
        String id;
        String name;
        String type;
        List<Value> values;

        public Filter() {
        }

        public List<Value> getValues() {
            return values;
        }

        public void setValues(List<Value> values) {
            this.values = values;
        }
    }

    public static class Value {

        String id;
        String name;
        List<path_from_root> path_from_root;

        public Value(String id, String name, Integer results, List path_from_root) {
            this.id = id;
            this.name = name;
            this.path_from_root = path_from_root;
        }

        public Value() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<path_from_root> getPath_from_root() {
            return path_from_root;
        }

        public void setPath_from_root(List<path_from_root> path_from_root) {
            this.path_from_root = path_from_root;
        }

    }

    public static class path_from_root {

        String id;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public class Average {

        Double PromedioUSD;
        Double PromedioMoneda;

        public Double getPromedioUSD() {
            return PromedioUSD;
        }

        public void setPromedioUSD(Double PromedioUSD) {
            this.PromedioUSD = PromedioUSD;
        }

        public Double getPromedioMoneda() {
            return PromedioMoneda;
        }

        public void setPromedioMoneda(Double PromedioMoneda) {
            this.PromedioMoneda = PromedioMoneda;
        }

        public Average(Double PromedioUSD, Double PromedioMoneda) {
            this.PromedioUSD = PromedioUSD;
            this.PromedioMoneda = PromedioMoneda;
        }

        public Average() {
        }
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

}
