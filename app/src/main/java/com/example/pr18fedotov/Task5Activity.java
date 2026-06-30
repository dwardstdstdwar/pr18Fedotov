package com.example.pr18fedotov;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Task5Activity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";

    ArrayList<HashMap<String, Object>> data;
    SimpleAdapter adapter;
    int count = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        data = new ArrayList<>();

        addItem("Запись 1");
        addItem("Запись 2");
        addItem("Запись 3");

        String[] from = {ATTRIBUTE_NAME_TEXT};
        int[] to = {R.id.tvText};

        adapter = new SimpleAdapter(
                this,
                data,
                R.layout.item_task5,
                from,
                to
        );

        ListView lvSimple = findViewById(R.id.lvSimple);
        lvSimple.setAdapter(adapter);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnRemove = findViewById(R.id.btnRemove);

        btnAdd.setOnClickListener(v -> {
            addItem("Запись " + count);
            count++;
            adapter.notifyDataSetChanged();
        });

        btnRemove.setOnClickListener(v -> {
            if (!data.isEmpty()) {
                data.remove(data.size() - 1);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void addItem(String text) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(ATTRIBUTE_NAME_TEXT, text);
        data.add(map);
    }
}
