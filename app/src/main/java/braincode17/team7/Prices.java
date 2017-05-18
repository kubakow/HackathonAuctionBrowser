package braincode17.team7;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Grzegorz on 24.03.2017.
 */

public class Prices implements Parcelable{

    private BuyNow buyNow;

    protected Prices(Parcel in) {
    }

    public static final Creator<Prices> CREATOR = new Creator<Prices>() {
        @Override
        public Prices createFromParcel(Parcel in) {
            return new Prices(in);
        }

        @Override
        public Prices[] newArray(int size) {
            return new Prices[size];
        }
    };

    public BuyNow getBuyNow() {
        return buyNow;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
