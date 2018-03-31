package com.example.hemant.agroinc;

import android.app.SearchManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AgricultureLibrary extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private MyAdapter adapter;
    private List<CropDetails> cropList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture_library);


        // toolbar fancy stuff


        recyclerView1 = (RecyclerView)findViewById(R.id.recycler_view2);
        cropList = new ArrayList<>();
        adapter = new MyAdapter(this, cropList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView1.setLayoutManager(mLayoutManager);
      //  recyclerView1.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(adapter);

        prepareCrop();





    }
    private void prepareCrop() {
        int[] covers = new int[]{
                R.drawable.wheath,
                R.drawable.legumes,
                R.drawable.apples,
                R.drawable.pears,
                R.drawable.mango,
                R.drawable.tomatoh,
                R.drawable.rice,
                R.drawable.cottonh,
                R.drawable.chilli,
                R.drawable.potato,
                R.drawable.paddy,
                R.drawable.onionh
              };

        CropDetails a = new CropDetails("Wheat\n" +
                "गेहूँ", covers[0],0);
        cropList.add(a);
        a = new CropDetails("Legumes\n" +
                "फलियां", covers[1],1);
        cropList.add(a);

        a = new CropDetails("Apple\n" +
                "सेब", covers[2],2);
        cropList.add(a);

        a = new CropDetails("Pears\n"+"रहिला", covers[3],3);
        cropList.add(a);


        a = new CropDetails("Mango\n" + "आम", covers[4],4);
        cropList.add(a);
        a = new CropDetails("Tomato\n" +
                "टमाटर", covers[5],5);
        cropList.add(a);
        a = new CropDetails("Rice\n" +
                "चावल", covers[6],6);
        cropList.add(a);
        a = new CropDetails("Cotton\n" +
                "कपास", covers[7],7);
        cropList.add(a);
        a = new CropDetails("Chilli\n" +
                "मिर्च", covers[8],8);
        cropList.add(a);
        a = new CropDetails("Potato\n" +
                "आलू", covers[9],9);
        cropList.add(a);
        a = new CropDetails("Paddy\n" + "धान", covers[10],10);
        cropList.add(a);

        a = new CropDetails("Onion\n"+"प्याज", covers[11],11);
        cropList.add(a);
        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(AgricultureLibrary.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {

            super.onBackPressed();
    }}

 /*   private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
   }*/
}





