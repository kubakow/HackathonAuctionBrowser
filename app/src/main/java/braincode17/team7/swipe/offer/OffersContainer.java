package braincode17.team7.swipe.offer;

import java.util.List;

import braincode17.team7.model.Offers;

/**
 * Created by Grzegorz on 25.03.2017.
 */

public class OffersContainer {

    private List<Offers> offers;
    private int count;

    public OffersContainer(List<Offers> offers, int count) {
        this.offers = offers;
        this.count = count;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public int getCount() {
        return count;
    }
}
