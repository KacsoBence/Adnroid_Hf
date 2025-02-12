package com.example.labor5;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    ArrayList<String> fruitList;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fruitList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.fruitList)));
        myListView = findViewById(R.id.fruitList);

        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruitList);
        myListView.setAdapter(myAdapter);

        registerForContextMenu(myListView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sort) {
            Collections.sort(fruitList);
            myAdapter.notifyDataSetChanged();
            return true;
        } else if (id == R.id.delete) {
            fruitList.clear();
            myAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = info.position;
        int id = item.getItemId();
        View view = myListView.getChildAt(pos);
        if (view != null) {
            TextView textView = view.findViewById(android.R.id.text1);

            if (id == R.id.red) {
                textView.setTextColor(ContextCompat.getColor(this, R.color.custom_red));
            } else if (id == R.id.green) {
                textView.setTextColor(ContextCompat.getColor(this, R.color.custom_green));
            } else if (id == R.id.yellow) {
                textView.setTextColor(ContextCompat.getColor(this, R.color.custom_yellow));
            }

        }
        return super.onContextItemSelected(item);
    }

}