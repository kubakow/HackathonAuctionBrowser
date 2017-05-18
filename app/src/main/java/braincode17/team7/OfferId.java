package braincode17.team7;

import java.util.List;

/**
 * Created by Grzegorz on 24.03.2017.
 */

public class OfferId {
    private List<Gallery> gallery;
    private Description description;
    private Seller seller;
    private String id;
    private String name;
    private MainImage mainImage;
    private Long endingTime;
    private Prices prices;
    private boolean buyNow;

    public boolean isBuyNow() {
        return buyNow;
    }

    public Description getDescription() {
        return description;
    }

    public Seller getSeller() {
        return seller;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MainImage getMainImage() {
        return mainImage;
    }

    public Long getEndingTime() {
        return endingTime;
    }

    public Prices getPrices() {
        return prices;
    }

    public List<Gallery> getGallery() {
        return gallery;
    }
}
