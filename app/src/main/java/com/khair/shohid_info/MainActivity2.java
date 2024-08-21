package com.khair.shohid_info;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        drawerLayout=findViewById(R.id.drawerlayout);
        materialToolbar=findViewById(R.id.Toolbar);
        navigationView=findViewById(R.id.NavigationView);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);


        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                MainActivity2.this,drawerLayout,materialToolbar,R.string.CloseDrawer,R.string.openDrawer);
        drawerLayout.addDrawerListener(toggle);

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.FrameLayout,new home_Fragment());
        transaction.commit();




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.home){
                    Toast.makeText(MainActivity2.this, "Home", Toast.LENGTH_SHORT).show();
                    FragmentManager manager=getSupportFragmentManager();
                    FragmentTransaction transaction=manager.beginTransaction();
                    transaction.add(R.id.FrameLayout,new home_Fragment());
                    transaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);

                } else if (item.getItemId()==R.id.profile) {
                    Toast.makeText(MainActivity2.this, "profile", Toast.LENGTH_SHORT).show();
                    FragmentManager manager=getSupportFragmentManager();
                    FragmentTransaction transaction=manager.beginTransaction();
                    transaction.add(R.id.FrameLayout,new profile_Fragment());
                    transaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);

                }
                else if (item.getItemId()==R.id.Setting) {
                    Toast.makeText(MainActivity2.this, "Setting", Toast.LENGTH_SHORT).show();
                    FragmentManager manager=getSupportFragmentManager();
                    FragmentTransaction transaction=manager.beginTransaction();
                    transaction.add(R.id.FrameLayout,new Setting_Fragment());
                    transaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);

                }


                return true;
            }
        });

        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });


        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });







    }
}