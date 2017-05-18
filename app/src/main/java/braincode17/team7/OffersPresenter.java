package braincode17.team7;

import android.util.Log;

import io.reactivex.Observable;
import nucleus.presenter.Presenter;
import retrofit2.Retrofit;

/**
 * Created by Grzegorz on 25.03.2017.
 */

public class OffersPresenter extends Presenter<SwipeOfferActivity> {

    private Retrofit retrofit;

    public Observable<OffersContainer> getData(String countryCode, String phrase, int limit) {
        return retrofit.create(RetrofitService.class).getOfferList(countryCode, phrase, limit);
    }

    public Observable<OffersContainer> getData(String countryCode, String phrase, int limit, String categoryId) {
        return retrofit.create(RetrofitService.class).getOfferList(countryCode, phrase, limit, categoryId);
    }

    public Observable<OffersContainer> getData(String countryCode, String phrase, int limit, String priceFrom, String priceTo) {
        Log.d("KuchniaBledy", countryCode + " " + phrase + " " + limit + " " + priceFrom + " " + priceTo);
        return retrofit.create(RetrofitService.class).getOfferList(countryCode, phrase, limit, priceFrom, priceTo);
    }

    public Observable<OffersContainer> getData(String countryCode, String phrase, int limit, String categoryId, String priceFrom, String priceTo) {
        return retrofit.create(RetrofitService.class).getOfferList(countryCode, phrase, limit, categoryId, priceFrom, priceTo);
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }



}
