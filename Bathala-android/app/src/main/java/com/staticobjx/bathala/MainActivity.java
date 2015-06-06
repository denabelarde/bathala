package com.staticobjx.bathala;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {


    @InjectView(R.id.parent_layout)
    RelativeLayout parentLayout;
    GoogleMap myMap;
    MapFragment mapFragment;
    ResideMenu resideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        mapFragment = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map));
        resideMenu.attachToActivity(this);
        myMap = mapFragment.getMap();
        // create menu items;
        String titles[] = {"All", "Events", "Disaster", "Festival", "Others"};
        int icon[] = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};

        for (int i = 0; i < titles.length; i++) {
            ResideMenuItem item = new ResideMenuItem(this, icon[i], titles[i]);
            resideMenu.addMenuItem(item, ResideMenu.DIRECTION_RIGHT); // or  ResideMenu.DIRECTION_RIGHT
        }
        resideMenu.addIgnoredView(parentLayout);
    }

    public void openCategories(View view) {
        resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
