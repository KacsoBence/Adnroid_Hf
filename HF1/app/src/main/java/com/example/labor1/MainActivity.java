package com.example.labor1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

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

        setTitle("Calculator");

        EditText firstNumber = findViewById(R.id.firstNumberInput);
        EditText secondNumber = findViewById(R.id.secondNumberInput);
        TextView result = findViewById(R.id.result);
        Button sum = findViewById(R.id.btnSum);
        Button difference = findViewById(R.id.btnDifference);
        Button multiplication = findViewById(R.id.btnMultiplication);
        Button division = findViewById(R.id.btnDivision);

        sum.setOnClickListener(view -> calculate(firstNumber, secondNumber, result, "+"));
        difference.setOnClickListener(view -> calculate(firstNumber, secondNumber, result, "-"));
        multiplication.setOnClickListener(view -> calculate(firstNumber, secondNumber, result, "*"));
        division.setOnClickListener(view -> calculate(firstNumber, secondNumber, result, "/"));

    }

    private void calculate(EditText firstNumber, EditText secondNumber, TextView result, String operator) {

        String number1 = firstNumber.getText().toString();
        String number2 = secondNumber.getText().toString();

        try {

            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            double calResult = 0;

            switch (operator) {

                case "+":
                    calResult = num1 + num2;
                    break;

                case "-":
                    calResult = num1 - num2;
                    break;

                case "*":
                    calResult = num1 * num2;
                    break;

                case "/":
                    calResult = num1 / num2;
                    break;
            }

            result.setText(String.valueOf((calResult)));

        } catch (NumberFormatException e) {
            result.setText("Error in converting number!");
        }

    }

}