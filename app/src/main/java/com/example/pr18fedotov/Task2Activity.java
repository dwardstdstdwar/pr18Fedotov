package com.example.pr18fedotov;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Task2Activity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        String[] texts = {"Ноутбук", "Телефон", "Планшет", "Наушники"};
        boolean[] checked = {true, false, true, false};
        int[] images = {
                android.R.drawable.ic_menu_manage,
                android.R.drawable.ic_menu_call,
                android.R.drawable.ic_menu_gallery,
                android.R.drawable.ic_btn_speak_now
        };

        ArrayList<HashMap<String, Object>> data = new ArrayList<>();

        for (int i = 0; i < texts.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            map.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
            map.put(ATTRIBUTE_NAME_IMAGE, images[i]);
            data.add(map);
        }

        String[] from = {
                ATTRIBUTE_NAME_TEXT,
                ATTRIBUTE_NAME_CHECKED,
                ATTRIBUTE_NAME_IMAGE
        };

        int[] to = {
                R.id.tvText,
                R.id.cbBox,
                R.id.ivImg
        };

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                R.layout.item,
                from,
                to
        );

        lvSimple = findViewById(R.id.lvSimple);
        lvSimple.setAdapter(adapter);
    }
}
