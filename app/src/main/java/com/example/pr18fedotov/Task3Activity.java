package com.example.pr18fedotov;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Task3Activity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        String[] texts = {"Красный", "Зелёный", "Синий", "Жёлтый"};
        int[] images = {
                android.R.drawable.presence_busy,
                android.R.drawable.presence_online,
                android.R.drawable.presence_invisible,
                android.R.drawable.presence_away
        };

        ArrayList<HashMap<String, Object>> data = new ArrayList<>();

        for (int i = 0; i < texts.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            map.put(ATTRIBUTE_NAME_IMAGE, images[i]);
            data.add(map);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.ivImg};

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                R.layout.item_task3,
                from,
                to
        );

        ListView lvSimple = findViewById(R.id.lvSimple);
        lvSimple.setAdapter(adapter);
    }
}
