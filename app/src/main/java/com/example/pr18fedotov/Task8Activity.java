package com.example.pr18fedotov;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Task8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task8);

        ListView lvProducts = findViewById(R.id.lvProducts);

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Ноутбук", "Цена: 55000 руб.", android.R.drawable.ic_menu_manage));
        products.add(new Product("Телефон", "Цена: 25000 руб.", android.R.drawable.ic_menu_call));
        products.add(new Product("Планшет", "Цена: 30000 руб.", android.R.drawable.ic_menu_gallery));
        products.add(new Product("Наушники", "Цена: 5000 руб.", android.R.drawable.ic_btn_speak_now));

        ProductAdapter adapter = new ProductAdapter(this, products);
        lvProducts.setAdapter(adapter);
    }
}
