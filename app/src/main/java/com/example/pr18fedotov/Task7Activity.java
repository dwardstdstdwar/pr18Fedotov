package com.example.pr18fedotov;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleCursorTreeAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class Task7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task7);

        ExpandableListView elvMain = findViewById(R.id.elvMain);

        MatrixCursor groupCursor = new MatrixCursor(new String[]{"_id", "groupName"});
        groupCursor.addRow(new Object[]{1, "Фрукты"});
        groupCursor.addRow(new Object[]{2, "Овощи"});
        groupCursor.addRow(new Object[]{3, "Напитки"});

        SimpleCursorTreeAdapter adapter = new SimpleCursorTreeAdapter(
                this,
                groupCursor,
                R.layout.group_task7,
                new String[]{"groupName"},
                new int[]{R.id.tvGroup},
                R.layout.child_task7,
                new String[]{"childName"},
                new int[]{R.id.tvChild}
        ) {
            @Override
            protected Cursor getChildrenCursor(Cursor groupCursor) {
                int groupId = groupCursor.getInt(groupCursor.getColumnIndexOrThrow("_id"));

                MatrixCursor childCursor = new MatrixCursor(new String[]{"_id", "childName"});

                if (groupId == 1) {
                    childCursor.addRow(new Object[]{1, "Яблоко"});
                    childCursor.addRow(new Object[]{2, "Банан"});
                    childCursor.addRow(new Object[]{3, "Апельсин"});
                } else if (groupId == 2) {
                    childCursor.addRow(new Object[]{4, "Картофель"});
                    childCursor.addRow(new Object[]{5, "Морковь"});
                    childCursor.addRow(new Object[]{6, "Огурец"});
                } else if (groupId == 3) {
                    childCursor.addRow(new Object[]{7, "Чай"});
                    childCursor.addRow(new Object[]{8, "Кофе"});
                    childCursor.addRow(new Object[]{9, "Сок"});
                }

                return childCursor;
            }
        };

        elvMain.setAdapter(adapter);
    }
}
