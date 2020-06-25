package com.example.quora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ImageButton bt_person;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private String title="Home";
    private FloatingActionButton fab;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
        //set fragment va title neu khi moi vao
        setFragmentTransaction(new Fragment_home());
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");


        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open_drawer,
                R.string.navigation_close_drawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

    }

    private void setControl() {
        toolbar=findViewById(R.id.toolbar);
        bottomNavigationView =findViewById(R.id.bottom_navigation);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        fab =findViewById(R.id.fab);
        //dung cai nay de get id tu drawlayout
        View view=navigationView.getHeaderView(0);
        bt_person=view.findViewById(R.id.bt_person);
    }

    private void setEvent(){
        setSupportActionBar(toolbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home1:
                        fragment=new Fragment_home();
                        title="Home";
                        break;
                    case R.id.edit:
                        fragment=new Fragment_edit();
                        title="Edit";
                        break;
                    case R.id.social:
                        fragment=new Fragment_social();
                        title="Social";
                        break;
                    case R.id.notifcation:
                        fragment=new Fragment_notification();
                        title="Notfication";
                        break;
                }
                toolbar.setTitle(title);
                setFragmentTransaction(fragment);
                return true;
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.message1:
                        Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.stats:
                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.content1:
                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bookmarks:
                        Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drafts:
                        Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        bt_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Test Person", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Test Fab", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setFragmentTransaction(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,fragment);
        //ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}