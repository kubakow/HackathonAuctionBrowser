package braincode17.team7;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Grzegorz on 25.03.2017.
 */

public class Images implements Parcelable{

    private String url;

    protected Images(Parcel in) {
        url = in.readString();
    }

    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };

    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }
}
