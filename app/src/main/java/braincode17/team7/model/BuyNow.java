package braincode17.team7.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Grzegorz on 25.03.2017.
 */

public class BuyNow implements Parcelable{

    private String amount;
    private String currency;

    protected BuyNow(Parcel in) {
        amount = in.readString();
        currency = in.readString();
    }

    public static final Creator<BuyNow> CREATOR = new Creator<BuyNow>() {
        @Override
        public BuyNow createFromParcel(Parcel in) {
            return new BuyNow(in);
        }

        @Override
        public BuyNow[] newArray(int size) {
            return new BuyNow[size];
        }
    };

    public String getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(amount);
        dest.writeString(currency);
    }
}
