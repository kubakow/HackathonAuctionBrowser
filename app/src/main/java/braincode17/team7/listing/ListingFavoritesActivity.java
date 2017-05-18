package braincode17.team7.listing;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;


import braincode17.team7.MainActivity;
import braincode17.team7.R;
import braincode17.team7.SettingsActivity;
import braincode17.team7.SwipeOfferActivity;
import java.util.ArrayList;
import braincode17.team7.Offers;
import braincode17.team7.R;
import braincode17.team7.StaticFields;
import braincode17.team7.details.DetailOfferActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.Url;

public class ListingFavoritesActivity extends AppCompatActivity implements OnOfferItemClickListener{

    private FavoritesListAdapter favoritesListAdapter;


    @BindView(R.id.rv_listing)
    RecyclerView recyclerViewListing;
    private ArrayList<Offers> listOfFavs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_favorites);
        ButterKnife.bind(this);
        favoritesListAdapter = new FavoritesListAdapter();
        if(getIntent().getParcelableArrayListExtra(StaticFields.PARCELED_ARRAY)!=null) {
            listOfFavs = getIntent().getParcelableArrayListExtra(StaticFields.PARCELED_ARRAY);

            favoritesListAdapter.setFavoriteOffersList(listOfFavs);
        }
        favoritesListAdapter.setOnOfferItemClickListener(this);
        recyclerViewListing.setAdapter(favoritesListAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewListing.setLayoutManager(layoutManager);

    }

    public static Intent createIntent(Context context, ArrayList<Offers> offersListFromSwipe) {
        Intent intent = new Intent(context, ListingFavoritesActivity.class);
        intent.putParcelableArrayListExtra(StaticFields.PARCELED_ARRAY, offersListFromSwipe);
        return intent;
    }

    @Override
    public void onOfferItemClick(String id) {
//        Offers offer = new Offers(id);
//        String urlString = offer.getUrl();
//
//        Uri webpage = Uri.parse(urlString);
        Intent i = new Intent(Intent.ACTION_VIEW);
       i.setData(Uri.parse(id));
        startActivity(i);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {

            case R.id.menu_list: {
                Toast.makeText(this, "Tutaj jesteś:)", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_settings: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.menu_tinder: {
                Intent intent = new Intent(this, SwipeOfferActivity.class);
                startActivity(intent);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }


}
