package com.ptp.phamtanphat.navigationdrawer1409;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.GRAY));
        navigationView.setItemIconTintList(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.itemimport:
                        Show("Import");
                        fragment = new Fragment_Android();
                        break;
                    case R.id.itemgallery:
                        Show("Gallery");
                        fragment = new Fragment_iOS();
                        break;
                    case R.id.itemslideshow:
                        Show("Slideshow");
                        fragment = new Fragment_Php();
                        break;
                    case R.id.itemtools:
                        Show("Tools");
                        fragment = new Fragment_Android();
                        break;
                    case R.id.itemshare:
                        Show("Share");
                        fragment = new Fragment_iOS();
                        break;
                    case R.id.itemsend:
                        Show("Send");
                        fragment = new Fragment_Php();
                        break;
                }
                fragmentTransaction.replace(R.id.contentlayout,fragment);
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(Gravity.START);
                return true;
            }
        });
    }

    public void Show(String tenitem) {
        Toast.makeText(this, tenitem, Toast.LENGTH_SHORT).show();
    }

    private void anhxa() {
        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
    }
}
