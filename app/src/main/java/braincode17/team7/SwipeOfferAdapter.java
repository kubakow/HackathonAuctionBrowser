package braincode17.team7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Grzegorz on 24.03.2017.
 */

public class SwipeOfferAdapter extends BaseAdapter {

    private List<Offers> offersList = new ArrayList<>();

    public List<Offers> getOffersList() {
        return offersList;
    }

    @Override
    public int getCount() {
        return offersList.size();
    }

    @Override
    public Object getItem(int i) {
        return offersList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View layout, ViewGroup viewGroup) {
        if (offersList.get(position).isBuyNow() && !offersList.get(position).isAuction()&& offersList.get(position).getImages().get(0).getUrl()!=null) {

            layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_view_layout, viewGroup, false);
            ImageView offerImage = (ImageView) layout.findViewById(R.id.offer_image);
            TextView describtionText = (TextView) layout.findViewById(R.id.describtion_text);
            TextView priceText = (TextView) layout.findViewById(R.id.price_text);
            if (!offersList.get(position).isBuyNow()) {
                offersList.remove(position);
            } else {
                Glide.with(offerImage.getContext()).load(offersList.get(position).getImages().get(0).getUrl()).into(offerImage);
                describtionText.setText(offersList.get(position).getName());
                priceText.setText(offersList.get(position).getPrices().getBuyNow().getAmount() + " " + offersList.get(position).getPrices().getBuyNow().getCurrency());
            }

            return layout;
        } else {
            return null;
        }
    }

    public void setOffersList(List<Offers> offersList) {
        this.offersList = offersList;
    }
}
