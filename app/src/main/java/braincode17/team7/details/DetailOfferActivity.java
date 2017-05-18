package braincode17.team7.details;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import braincode17.team7.MainActivity;
import braincode17.team7.R;
import braincode17.team7.SettingsActivity;
import braincode17.team7.StaticFields;
import braincode17.team7.listing.ListingFavoritesActivity;

public class DetailOfferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_offer);

    }

    public static Intent createIntent(Context context, String id){
        Intent intent = new Intent (context, DetailOfferActivity.class);
        intent.putExtra(StaticFields.ID_KEY, id);
        return intent;
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
                Intent intent = new Intent(this, ListingFavoritesActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_settings: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
