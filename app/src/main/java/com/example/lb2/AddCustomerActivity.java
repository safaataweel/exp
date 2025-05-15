package com.example.lb2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        String[] options = { "Male", "Female" };
        final Spinner genderSpinner =(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> objGenderArr = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, options);
        genderSpinner.setAdapter(objGenderArr);


        final EditText idEditText = (EditText)findViewById(R.id.editTextText2);
        final EditText nameEditText = (EditText)findViewById(R.id.editTextText3);
        final EditText phoneEditText = (EditText)findViewById(R.id.editTextText4);
        final EditText addressEditText = (EditText)findViewById(R.id.editTextText);
        Button addCustomerButton = (Button) findViewById(R.id.button_Add_Customer);


        addCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Customer newCustomer =new Customer();

                if(idEditText.getText().toString().isEmpty()) newCustomer.setmCustomerId(0);
                else newCustomer.setmCustomerId(Long.parseLong(idEditText.getText().toString()));
                if(nameEditText.getText().toString().isEmpty()) newCustomer.setmName("No Name");
                else newCustomer.setmName(nameEditText.getText().toString());
                if(phoneEditText.getText().toString().isEmpty()) newCustomer.setmPhone("No Phone");
                else newCustomer.setmPhone(phoneEditText.getText().toString());
                if(addressEditText.getText().toString().isEmpty()) newCustomer.setMaddress("No Address");
                else newCustomer.setMaddress(addressEditText.getText().toString());

                newCustomer.setmGender(genderSpinner.getSelectedItem().toString());

                DataBaseHelper dataBaseHelper = new DataBaseHelper(AddCustomerActivity.this , "EXP4_DB" , null , 1);
                dataBaseHelper.insertCustomer(newCustomer)   ;

                Intent intent=new Intent(AddCustomerActivity.this,MainActivity.class);
                AddCustomerActivity.this.startActivity(intent);
                finish(); } });
    }
}