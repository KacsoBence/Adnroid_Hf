package com.example.labor3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<Product> productList;
    private TextView productListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setTitle("Table/ConstrainLayout");

        productList = new ArrayList<>();
        Button cancelButton = findViewById(R.id.btnCancel);
        Button addProduct = findViewById(R.id.btnAddProduct);
        Button showProducts = findViewById(R.id.btnPrintProducts);
        EditText productCodeInput = findViewById(R.id.productCodeInput);
        EditText productNameInput = findViewById(R.id.productNameInput);
        EditText productPriceInput = findViewById(R.id.productPriceInput);

        productListTextView = findViewById(R.id.productListTextView);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = productCodeInput.getText().toString();
                String name = productNameInput.getText().toString();
                String priceString = productPriceInput.getText().toString();

                if (code.isEmpty() || name.isEmpty() || priceString.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                    return ;
                }

                float price = 0;
                try {
                    price = Float.parseFloat(priceString);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid price!", Toast.LENGTH_SHORT).show();
                    return ;
                }

                Product product = new Product(code, name, price);
                productList.add(product);

                productListTextView.setText(null);
                productCodeInput.setText(null);
                productNameInput.setText(null);
                productPriceInput.setText(null);
            }
        });

        showProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productListTextView.setText(null);
                printProductList();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productListTextView.setText(null);
                productCodeInput.setText(null);
                productNameInput.setText(null);
                productPriceInput.setText(null);
            }
        });

    }

    private void printProductList() {
        for (Product product : productList) {
            productListTextView.append(product.toString() + "\n");
        }
    }

}