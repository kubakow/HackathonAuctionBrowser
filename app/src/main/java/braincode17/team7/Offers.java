package braincode17.team7;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Grzegorz on 25.03.2017.
 */

public class Offers implements Parcelable{

    public Offers(String id) {
        this.id = id;
    }

    private String id;
    private String url;
    private boolean auction;
    private boolean advert;
    private boolean buyNow;
    private String name;
    private boolean cartAvailable;
    private Quantity quantity;
    private Prices  prices;

    private List<Parameters> parameters;

    private List<Images> images;


    protected Offers(Parcel in) {
        id = in.readString();
        url = in.readString();
        auction = in.readByte() != 0;
        advert = in.readByte() != 0;
        buyNow = in.readByte() != 0;
        name = in.readString();
        cartAvailable = in.readByte() != 0;
        prices = in.readParcelable(Prices.class.getClassLoader());
        images = in.createTypedArrayList(Images.CREATOR);
    }

    public static final Creator<Offers> CREATOR = new Creator<Offers>() {
        @Override
        public Offers createFromParcel(Parcel in) {
            return new Offers(in);
        }

        @Override
        public Offers[] newArray(int size) {
            return new Offers[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public boolean isAuction() {
        return auction;
    }

    public boolean isAdvert() {
        return advert;
    }

    public boolean isBuyNow() {
        return buyNow;
    }

    public boolean isCartAvailable() {
        return cartAvailable;
    }


    public Quantity getQuantity() {
        return quantity;
    }

    public Prices getPrices() {
        return prices;
    }

    public List<Images> getImages() {
        return images;
    }

    public List<Parameters> getParameters() {
        return parameters;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(url);
        dest.writeByte((byte) (auction ? 1 : 0));
        dest.writeByte((byte) (advert ? 1 : 0));
        dest.writeByte((byte) (buyNow ? 1 : 0));
        dest.writeString(name);
        dest.writeByte((byte) (cartAvailable ? 1 : 0));
        dest.writeParcelable(prices, flags);
        dest.writeTypedList(images);
    }
}
