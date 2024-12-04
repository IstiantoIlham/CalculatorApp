package com.example.calculatorapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1;
    private EditText etNumber2;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiple;
    private Button btnDivide;
    private TextView tvResult;

    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiple = findViewById(R.id.btnMultiple);
        btnDivide = findViewById(R.id.btnDivide);
        tvResult = findViewById(R.id.tvResult);
        btnReset = findViewById(R.id.btnReset);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = etNumber1.getText().toString();
                String number2 = etNumber2.getText().toString();
                if (!isNumber(number1, number2)) {
                    return;
                }
                try {
                    int result = Integer.parseInt(number1) + Integer.parseInt(number2);
                    tvResult.setText(String.valueOf(result));
                    hideKeyboard(v);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Masukan angka yang valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = etNumber1.getText().toString();
                String number2 = etNumber2.getText().toString();

                if (!isNumber(number1, number2)) {
                    return;
                }
                try {
                    int result = Integer.parseInt(number1) - Integer.parseInt(number2);
                    tvResult.setText(String.valueOf(result));
                    hideKeyboard(v);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Masukan angka yang valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = etNumber1.getText().toString();
                String number2 = etNumber2.getText().toString();

                if (!isNumber(number1, number2)) {
                    return;
                }
                try {
                    int result = Integer.parseInt(number1) * Integer.parseInt(number2);
                    tvResult.setText(String.valueOf(result));
                    hideKeyboard(v);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Masukan angka yang valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = etNumber1.getText().toString();
                String number2 = etNumber2.getText().toString();

                if (!isNumber(number1, number2)) {
                    return;
                }
                try {
                    int result = Integer.parseInt(number1) / Integer.parseInt(number2);
                    tvResult.setText(String.valueOf(result));
                    hideKeyboard(v);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Masukan angka yang valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber1.setText("");
                etNumber2.setText("");
                tvResult.setText("0");
            }
        });

    }

    private boolean isNumber(String number1, String number2) {
        if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(MainActivity.this, "Harus mengisi nomer", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void hideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}