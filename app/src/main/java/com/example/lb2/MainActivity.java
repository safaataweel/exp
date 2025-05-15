package com.example.lb2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout firstLinearLayout;
    private LinearLayout secondLinearLayout;
    private Button addButton;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firstLinearLayout = new LinearLayout(this);
        secondLinearLayout = new LinearLayout(this);
        addButton = new Button(this);
        scrollView = new ScrollView(this);

        firstLinearLayout.setOrientation(LinearLayout.VERTICAL);
        secondLinearLayout.setOrientation(LinearLayout.VERTICAL);
        addButton.setText("Add Customer");
        addButton.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        firstLinearLayout.addView(addButton);
        scrollView.addView(secondLinearLayout);
        firstLinearLayout.addView(scrollView);

        setContentView(firstLinearLayout);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCustomerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, "EXP4_DB" , null, 1);
        Cursor allCustomersCursor = dataBaseHelper.getAllCustomers();

        secondLinearLayout.removeAllViews();

        while (allCustomersCursor.moveToNext()) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(
                    "Id= " + allCustomersCursor.getString(0) + "\n" +
                            "Name= " + allCustomersCursor.getString(1) + "\n" +
                            "Phone= " + allCustomersCursor.getString(2) + "\n" +
                            "Gender= " + allCustomersCursor.getString(3) + "\n"+
                            "Address= " + allCustomersCursor.getString(4) + "\n\n"
            );
            secondLinearLayout.addView(textView);
        }


    }
}
