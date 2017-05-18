package braincode17.team7.listing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import braincode17.team7.Offers;
import braincode17.team7.R;

/**
 * Created by Kuba on 2017-03-25.
 */

public class FavoritesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnOfferItemClickListener onOfferItemClickListener;

    public void setOnOfferItemClickListener(OnOfferItemClickListener onOfferItemClickListener) {
        this.onOfferItemClickListener = onOfferItemClickListener;
    }

    private List<Offers> favoriteOffersList = new ArrayList<Offers>();

    public List<Offers> getFavoriteOffersList() {
        return favoriteOffersList;
    }

    public void addToFavoritesOffersList(Offers offer){
        favoriteOffersList.add(offer);
        notifyDataSetChanged();
    }

    public void setFavoriteOffersList(List<Offers> favoriteOffersList) {
        this.favoriteOffersList = favoriteOffersList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_listing_item, parent, false);
        return new FavoritesViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      
    Offers offer = favoriteOffersList.get(position);
    FavoritesViewHolder favoritesViewHolder = (FavoritesViewHolder) holder;
    if(offer.getImages()!=null) {
        Glide.with(favoritesViewHolder.itemImage.getContext()).load(offer.getImages().get(0).getUrl()).into(favoritesViewHolder.itemImage);
    }
    favoritesViewHolder.itemName.setText(offer.getName());
    if (offer.getPrices()!=null && offer.getPrices().getBuyNow()!=null) {

        favoritesViewHolder.itemPrice.setText(offer.getPrices().getBuyNow().getAmount() + " " + offer.getPrices().getBuyNow().getCurrency());
    }
        favoritesViewHolder.itemView.setOnClickListener(v -> {
            if (onOfferItemClickListener != null) {
                onOfferItemClickListener.onOfferItemClick(offer.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteOffersList.size();
    }

    class FavoritesViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;

        public FavoritesViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemImage = (ImageView) itemView.findViewById(R.id.iv_listing_item_image);
            itemName = (TextView) itemView.findViewById(R.id.tv_listing_item_name_of_product);
            itemPrice = (TextView) itemView.findViewById(R.id.tv_listing_item_price_buy_now);
        }
    }
}
