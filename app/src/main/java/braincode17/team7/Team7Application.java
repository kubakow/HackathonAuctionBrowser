package braincode17.team7;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Team7Application extends Application implements OffersProvider, OfferDetailsProvider {

    private Retrofit retrofitOffers;
    private Retrofit retrofitOfferDetails;

    private String offersURL = "https://allegroapi.io";
    // apiKey z README.pdf:
    private String apiKey = "eyJjbGllbnRJZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.ogVV_a9RUOMa1OWFZOTmgTkdk-U37vTliDCBUQ1YySU=";
    private String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0MzYxNTUsImp0aSI6IjQ0NDg5N2NlLWY5NjItNGEwMy1hZmU0LWFjNTJjMjVjZWM3MyIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.8xjUE1IyY7sYzMb5RtEIZEewoSw_QO2Rc-gMDUkMRkpZWkHDHq9L94aX8PscZdbJs7Ig-NX-3o-EEh5NgcqfdDw2J5ybsIVqriquL3OX21d6TyQ7Lg8Kj9uv7lTu88VJawh7qbFbQIG8LnKj5CtHghrLIiQUnxufpOD_Bbq47u_JpYEz1R89H1tBuk4dCuJQGF1b5ruwc2oIpM5fYPbIrnFHQnnmU5VNREuKVBtFpqcEjU5yeiX3EP_fPtzCtXdi9FyS_KCbGcJERpbsXn0bskMhITwSzqA0HgUAWeKLi6Ua2tSdndwbzWmI2fvQc4tkcgrmDpQ9VLoi_jg2RSg_IQ";

    private String offerDetailsURL = "https://api.natelefon.pl";

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitOffers = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(offersURL)
                .build();

        retrofitOfferDetails = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(offerDetailsURL)
                .build();
    }

    @Override
    public Retrofit provideOffersRetrofit() {
        return retrofitOffers;
    }

    @Override
    public Retrofit provideOfferDetailsRetrofit() {
        return retrofitOfferDetails;
    }
}
