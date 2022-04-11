package com.example.mark1navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.SortedSet;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    MaintenancePaymentFragment maintenancePaymentFragment = new MaintenancePaymentFragment();
    MaintenanceUpdateFragment maintenanceUpdateFragment = new MaintenanceUpdateFragment();
    WorkersPaymentFragment workersPaymentFragment = new WorkersPaymentFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_navBar);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,homeFragment).commit();
                        return true;

                    case R.id.maintenance_payment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,maintenancePaymentFragment).commit();
                        return true;

                    case R.id.maintenance_update:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,maintenanceUpdateFragment).commit();
                        return true;

                    case R.id.workers_payment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,workersPaymentFragment).commit();
                        return true;

                    case R.id.settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,settingsFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}