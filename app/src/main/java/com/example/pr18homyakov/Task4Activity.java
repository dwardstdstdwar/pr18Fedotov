package com.example.pr18homyakov;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Task4Activity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_COLOR = "color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        String[] texts = {"Java", "Kotlin", "Python", "C++"};
        boolean[] checked = {true, false, true, false};
        int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA};

        ArrayList<HashMap<String, Object>> data = new ArrayList<>();

        for (int i = 0; i < texts.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            map.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
            map.put(ATTRIBUTE_NAME_COLOR, colors[i]);
            data.add(map);
        }

        String[] from = {
                ATTRIBUTE_NAME_TEXT,
                ATTRIBUTE_NAME_CHECKED,
                ATTRIBUTE_NAME_COLOR
        };

        int[] to = {
                R.id.tvText,
                R.id.cbBox,
                R.id.tvText
        };

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                R.layout.item_task4,
                from,
                to
        );

        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                if (view.getId() == R.id.tvText && data instanceof Integer) {
                    TextView tv = (TextView) view;
                    tv.setTextColor((Integer) data);
                    return true;
                }

                if (view.getId() == R.id.cbBox) {
                    CheckBox cb = (CheckBox) view;
                    cb.setChecked((Boolean) data);
                    return true;
                }

                return false;
            }
        });

        ListView lvSimple = findViewById(R.id.lvSimple);
        lvSimple.setAdapter(adapter);
    }
}
