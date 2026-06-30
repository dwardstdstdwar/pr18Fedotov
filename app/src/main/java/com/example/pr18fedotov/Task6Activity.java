package com.example.pr18fedotov;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class Task6Activity extends AppCompatActivity {

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task6);

        lvSimple = findViewById(R.id.lvSimple);

        String[] columns = {"_id", "name", "email"};

        MatrixCursor cursor = new MatrixCursor(columns);

        cursor.addRow(new Object[]{1, "Иван", "ivan@mail.ru"});
        cursor.addRow(new Object[]{2, "Пётр", "petr@mail.ru"});
        cursor.addRow(new Object[]{3, "Анна", "anna@mail.ru"});
        cursor.addRow(new Object[]{4, "Мария", "maria@mail.ru"});

        String[] from = {"name", "email"};

        int[] to = {
                R.id.tvName,
                R.id.tvEmail
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.item_task6,
                cursor,
                from,
                to,
                0
        );

        lvSimple.setAdapter(adapter);
    }
}
