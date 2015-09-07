package com.demo.designdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.demo.fragment.AboutFragment;
import com.demo.fragment.DesignDemoFragment;
import com.demo.fragment.HomeFragment;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
//        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setUpNavigationView(navigationView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.coordinator), "I'm a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar Action", Toast.LENGTH_LONG).show();
                        // me
                        startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                    }
                }).show();
            }
        });

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

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // add by me
    private void setUpNavigationView(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                displayFragmentView(menuItem);
                return true;
            }
        });
    }

    private void displayFragmentView(MenuItem menuItem) {
//        Fragment fragment = null;
//        Class fragmentClass = null;
//
//        switch (menuItem.getItemId()) {
//            case R.id.nav_item_designdemo:
//                fragmentClass = DesignDemoFragment.class;
//                break;
//            case R.id.nav_item_home:
//                fragmentClass = HomeFragment.class;
//                break;
//            case R.id.nav_item_about:
//                fragmentClass = AboutFragment.class;
//                break;
//            case R.id.nav_item_contact:
//
//                break;
//            default:
//                fragmentClass = DesignDemoFragment.class;
//                break;
//        }
//
//        if (fragmentClass != null) {
//            try {
//                fragment = (Fragment) fragmentClass.newInstance();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        // another one
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()) {
            case R.id.nav_item_designdemo:
                DesignDemoFragment demo =  DesignDemoFragment.newInstance(R.id.nav_item_designdemo);
                trans.replace(R.id.frame_container, demo);
                break;
            case R.id.nav_item_home:
                HomeFragment home = HomeFragment.newInstance(R.id.nav_item_home);
                trans.replace(R.id.frame_container, home);
                break;
            case R.id.nav_item_about:
                AboutFragment about = new AboutFragment();
                trans.replace(R.id.frame_container, about);
                break;
            default:
                DesignDemoFragment tar =  DesignDemoFragment.newInstance(R.id.nav_item_designdemo);
                trans.replace(R.id.frame_container, tar);
                break;
        }
        trans.commit();

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }

}
