package com.obrero.cmycountry.activities;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.adapter.DrawerItemAdapter;
import com.obrero.cmycountry.dto.DrawerItem;

import java.util.ArrayList;

public class Home extends Activity {

    private static final String TAG = "Home";

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        
        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.drawable.ic_launcher,
                R.string.open_drawer,
                R.string.close_drawer){

            public void onDrawerClosed(View view) {
                Log.d(TAG, "opened Drawer");
            }


            /** Called when a drawer has settled in a completely open state. */

            public void onDrawerOpened(View drawerView) {
                Log.d(TAG, "closed Drawer");
            }
        };

        ArrayList<DrawerItem> entries = new ArrayList<DrawerItem>(1);
        entries.add(new DrawerItem(R.drawable.circle));
        DrawerItemAdapter adapter = new DrawerItemAdapter(this, entries);
        drawerList.setAdapter(adapter);

        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        drawerLayout.setDrawerListener(drawerToggle);

        getActionBar().setHomeButtonEnabled(true);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }


    public void selectItem(int position){

    }
}
