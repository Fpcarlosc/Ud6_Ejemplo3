package com.example.ud6_ejemplo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscamos el ViewPager y el TabLayout
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Creamos y asignamos el adaptador de Fragments
        AdapterFragments adapter = new AdapterFragments(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        // Conectamos el ViewPager con el TabLayout
        tabLayout.setupWithViewPager(viewPager);
    }
}
