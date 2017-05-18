package braincode17.team7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.daprlabs.aaron.swipedeck.SwipeDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import braincode17.team7.listing.FavoritesListAdapter;
import braincode17.team7.listing.ListingFavoritesActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusAppCompatActivity;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresPresenter(OffersPresenter.class)
public class SwipeOfferActivity extends NucleusAppCompatActivity<OffersPresenter> {

    @BindView(R.id.swipe_deck)
    SwipeDeck cardStack;
    SwipeOfferAdapter adapter;
    List<Offers> listOfOffersToIntent = new ArrayList<>();
    private String[] ourDictionary = {"Czołg", "Samolot", "Kubek", "Piwo", "Dzbanek", "Mieszkanie", "Kurtka", "Spodnie", "Rynna", "Dach", "Lego"};
    private int randomek = new Random().nextInt(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_deck_layout);
        ButterKnife.bind(this);

        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        adapter = new SwipeOfferAdapter();
        String phrase = getIntent().getStringExtra(StaticFields.SEARCH_PHRASE);
        String countryCode = "PL";
        String categoryIdFromIntent = getIntent().getStringExtra(StaticFields.CATEGORY_ID);
        String minPriceFromIntent = getIntent().getStringExtra(StaticFields.MIN_PRICE);
        String maxPriceFromIntent = getIntent().getStringExtra(StaticFields.MAX_PRICE);

        if (savedInstanceState == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://allegroapi.io")
                    .build();
            getPresenter().setRetrofit(retrofit);
        }

        if (cardStack != null) {
            cardStack.setAdapter(adapter);
        }

        FavoritesListAdapter favoritesListAdapter = new FavoritesListAdapter();
//        startLoading(countryCode, ourDictionary[randomek], 10);
        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long stableId) {
                Log.i("SwipeOfferActivity", "card was swiped left, position in adapter: " + stableId);
            }

            @Override
            public void cardSwipedRight(long stableId) {
                listOfOffersToIntent.add(adapter.getOffersList().get((int) stableId));
            }

        });

        cardStack.setLeftImage(R.id.right_image);
        cardStack.setRightImage(R.id.left_image);

        if (categoryIdFromIntent != null) {
            startLoading(countryCode, phrase, 10, categoryIdFromIntent);
        } else if (minPriceFromIntent != null && maxPriceFromIntent != null) {
            startLoading(countryCode, phrase, 10, minPriceFromIntent, maxPriceFromIntent);
        }


    }
    private void startLoading(String countryCode, String phrase, int limit) {
        getPresenter().getData(countryCode, phrase, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::success, this::error);
    }

    private void startLoading(String countryCode, String phrase, int limit, String categoryId) {
        getPresenter().getData(countryCode, phrase, limit, categoryId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::success, this::error);
    }

    private void startLoading(String countryCode, String phrase, int limit, String categoryId, String minPrice, String maxPrice) {
        getPresenter().getData(countryCode, phrase, limit, categoryId, minPrice, maxPrice)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::success, this::error);
    }

    private void startLoading(String countryCode, String phrase, int limit, String minPrice, String maxPrice) {
        getPresenter().getData(countryCode, phrase, limit, minPrice, maxPrice)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::success, this::error);
    }

    private void error(Throwable throwable) {
        Log.d("BledyKuchnia", throwable.getMessage());
    }

    private void success(OffersContainer offers) {
        adapter.setOffersList(offers.getOffers());
        adapter.notifyDataSetChanged();
    }

    public static Intent createIntent(Context context, String name, String categoryId, String minPrice, String maxPrice){
        Intent intent = new Intent(context,SwipeOfferActivity.class);
        intent.putExtra(StaticFields.SEARCH_PHRASE, name);
        intent.putExtra(StaticFields.CATEGORY_ID, categoryId);
        intent.putExtra(StaticFields.MIN_PRICE, minPrice);
        intent.putExtra(StaticFields.MAX_PRICE, maxPrice);
        return intent;
    }

    public static Intent createIntent(Context context, String name, String minPrice, String maxPrice){
        Intent intent = new Intent(context,SwipeOfferActivity.class);
        intent.putExtra(StaticFields.SEARCH_PHRASE, name);
        intent.putExtra(StaticFields.MIN_PRICE, minPrice);
        intent.putExtra(StaticFields.MAX_PRICE, maxPrice);
        return intent;
    }

    @OnClick(R.id.end_swipe_image)
    public void onEndSwipeImageClick(){
        Intent intent = new Intent(this, ListingFavoritesActivity.class);
        intent.putParcelableArrayListExtra(StaticFields.PARCELED_ARRAY, (ArrayList<? extends Parcelable>) listOfOffersToIntent);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            
            case R.id.menu_list: {
                Intent intent = new Intent(this, ListingFavoritesActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_settings: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.menu_tinder: {
                startLoading("PL", ourDictionary[randomek], 25);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
