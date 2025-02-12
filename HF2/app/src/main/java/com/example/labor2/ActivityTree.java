package com.example.labor2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityTree extends AppCompatActivity {

    EditText szoveg;
    CheckBox ellenorzes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tree);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setTitle("ActivityStateSaveTwo");

        Log.d("Statusz: ", "ActivityTree - onCreate");

        Button gomb = findViewById(R.id.backTwoAct);

        gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTree.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

        szoveg = findViewById(R.id.textInput);
        ellenorzes = findViewById(R.id.checkBox);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Statusz: ", "ActivityTree - onSaveInstanceState");
        outState.putString("txt", szoveg.getText().toString());
        outState.putBoolean("checkBox", ellenorzes.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Statusz: ", "ActivityTree - onRestoreInstanceState");
        szoveg.setText(savedInstanceState.getString("txt"));
        ellenorzes.setChecked(savedInstanceState.getBoolean("checkBox"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz: ", "ActivityTree - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz: ", "ActivityTree - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz: ", "ActivityTree - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz: ", "ActivityTree - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz: ", "ActivityTree - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz: ", "ActivityTree - onDestroy");
    }

}