package braincode17.team7.settings;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.appyvet.rangebar.RangeBar;

import java.util.HashMap;

import braincode17.team7.R;
import braincode17.team7.swipe.offer.SwipeOfferActivity;
import braincode17.team7.listing.ListingFavoritesActivity;
import braincode17.team7.utils.CategoriesUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.rb_price)
    RangeBar priceRangeBar;

    @BindView(R.id.ib_categories)
    ImageButton openCategoriesButton;

    @BindView(R.id.text_input_edit_text)
    TextInputEditText searchTextInputEditText;

    @BindView(R.id.ib_categories_close)
    ImageButton closeCategoriesButton;

    @BindView(R.id.rg_categories)
    RadioGroup radioGroupCategories;

    RadioButton radioButton;

    @BindView(R.id.left_range_price)
    TextView leftRangePrice;

    @BindView(R.id.right_range_price)
    TextView rightRangePrice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);


        priceRangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                leftRangePrice.setText(leftPinValue);
                if ("1000".equals(rightPinValue)) {
                    rightRangePrice.setText("1000+");
                } else {
                    rightRangePrice.setText(rightPinValue);
                }
            }
        });

        searchTextInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_NULL
                        && event.getAction() == KeyEvent.ACTION_DOWN) {
                    onSearchButtonClick();
                }
                return true;
            }
        });

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
                Toast.makeText(this, "Tutaj jesteś:)", Toast.LENGTH_SHORT).show();
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



    @OnClick(R.id.ib_categories)
    void onOpenCategoriesButtonClick(){
                openCategoriesButton.setVisibility(View.GONE);
                radioGroupCategories.setVisibility(View.VISIBLE);
                closeCategoriesButton.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.ib_categories_close)
    void onCloseCategoriesButtonClick(){
        closeCategoriesButton.setVisibility(View.GONE);
        radioGroupCategories.setVisibility(View.GONE);
        openCategoriesButton.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.search_button)
    void onSearchButtonClick() {
        String name = searchTextInputEditText.getText().toString();
        int selectedRadioButton = radioGroupCategories.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedRadioButton);
        String categoryid;
        if (radioButton != null && radioButton.isChecked()) {
            categoryid = CategoriesUtils.categoriesMap.get(radioButton.getText().toString());
        } else {
            categoryid = null;
        }
        String minprice = leftRangePrice.getText().toString();
        String maxprice;
        if ("1000+".equals(rightRangePrice)) {
            maxprice = "999999";
        } else {
            maxprice = rightRangePrice.getText().toString();
        }
        if (categoryid == null) {
            startActivity(SwipeOfferActivity.createIntent(this, name, minprice, maxprice));
        } else
            startActivity(SwipeOfferActivity.createIntent(this, name, categoryid, minprice, maxprice));
    }







}
