package model;

import java.net.URL;
import java.util.List;

public class User {

    private final String id;
    private final String nickname;
    private final String registration_date;
    private final String country_id;
    private final Adress address;
    private final String user_type;
    private final List<String> Tag;
    private URL logo = null;
    private final Integer points;
    private final String siteid;
    private final String permalink;
    private final SellerReputation seller_reputation;
    private final BuyerReputation buyer_reputation;
    private final Status status;

    public User(final String id, final String name, String siteid, String reg, String Country, Adress direccion, String usertipo, Integer pts, String permalink) {
        this.id = id;
        this.nickname = name;
        this.siteid = siteid;
        this.registration_date = reg;
        this.country_id = Country;
        this.address = direccion;
        this.user_type = usertipo;
        this.Tag = null;
        this.logo = null;
        this.points = pts;
        this.permalink = permalink;
        this.seller_reputation = null;
        this.buyer_reputation = null;
        this.status = null;

    }

    public String getAddressCity() {
        return this.address.getCity();
    }

    public String getAddressState() {
        return this.address.getState();
    }

    public String getId() {
        return id;
    }

    public String getUserType() {
        return user_type;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public Integer getPoints() {
        return points;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUserStatus() {
        return this.status.getSite_status();
    }

    @Override
    public String toString() {
        return "Site{"
                + "id='" + id + '\''
                + ", name='" + nickname + '\''
                + '}';
    }

    public String getSiteID() {
        return siteid;
    }

    public SellerReputation getSellerRep() {
        return this.seller_reputation;
    }

    public class SellerReputation {

        String level_id;
        String power_seller_status;

        public String getPower_seller_status() {
            return power_seller_status;
        }

        public SellerReputation(String level_id, String power_seller_status, Transactions transactions) {
            this.level_id = level_id;
            this.power_seller_status = power_seller_status;
            this.transactions = transactions;
        }
        Transactions transactions;

        public SellerReputation() {
        }
    }

    private static class Transactions {

        String period;
        Integer total;
        Integer completed;
        Integer canceled;
        Ratings ratings;

        public Transactions() {
        }
    }

    private static class Ratings {

        Integer Positive;
        Integer Negative;
        Integer Neutral;

        public Ratings() {
        }
    }

    private static class Status {

        String site_status;

        public String getSite_status() {
            return site_status;
        }

        public Status() {
        }
    }

    private static class BuyerReputation {

        List<String> tags;

        public BuyerReputation() {
        }
    }
}
