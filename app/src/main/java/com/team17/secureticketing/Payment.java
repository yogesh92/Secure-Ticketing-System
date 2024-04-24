package com.team17.secureticketing;

import android.app.DatePickerDialog;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {
    Button submit;
    int d, m, y;
    EditText expiration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        submit = findViewById(R.id.submit);
        expiration = findViewById(R.id.expiration);
        final User muser = (User) getIntent().getSerializableExtra("user");
        expiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Payment.this, listener, y, m, d).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Payment.this, "Payment is sucessful!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Payment.this, QRCode.class);
                i.putExtra("user", muser);
                startActivity(i);
                finish();
            }
        });

    }

    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            expiration.setText(i2 + "/" + (i1 + 1) + "/" + i);
            d = i2;
            m = i1;
            y = i;
        }
    };
}

