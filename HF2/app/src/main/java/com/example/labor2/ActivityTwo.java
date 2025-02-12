package com.example.labor2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityTwo extends AppCompatActivity {

    TextView cimke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setTitle("ActivityStateSave");

        Log.d("Statusz: ", "ActivityTwo - onCreate");

        Button gomb = findViewById(R.id.backMainAct);
        Button activityHaromGomb = findViewById(R.id.actTreeButton);

        gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTwo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        activityHaromGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTwo.this, ActivityTree.class);
                startActivity(intent);
            }
        });

        cimke = findViewById(R.id.textInput);

        cimke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cimke.append("\n" + cimke.getText().toString());
            }
        });

    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Statusz: ", "ActivityTwo - onSaveInstanceState");
        outState.putString("txt", cimke.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Statusz: ", "ActivityTwo - onRestoreInstanceState");
        cimke.setText(savedInstanceState.getString("txt"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz: ", "ActivityTwo - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz: ", "ActivityTwo - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz: ", "ActivityTwo - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz: ", "ActivityTwo - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz: ", "ActivityTwo - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz: ", "ActivityTwo - onDestroy");
    }

}