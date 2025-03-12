package com.nicolas.appcalculafacil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button Cal = findViewById(R.id.btnCalcular);
        Cal.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btnCalcular){

            EditText edMetro = findViewById(R.id.altura);
            EditText edKg = findViewById(R.id.peso);

            float Kg = Float.parseFloat(edKg.getText().toString());
            float Metro = Float.parseFloat(edMetro.getText().toString());
            float resultado = Kg / (Metro * Metro);

            if (resultado < 18.5) {
                Toast.makeText(HomeActivity.this, "Você está abaixo do peso tendo um IMC de " + resultado, Toast.LENGTH_LONG).show();
            } else if (resultado >= 18.5 && resultado < 24.9) {
                Toast.makeText(HomeActivity.this, "Voce esta com o peso normal tendo um IMC de " + resultado, Toast.LENGTH_LONG).show();
            } else if (resultado >= 25 && resultado < 30) {
                Toast.makeText(HomeActivity.this, "Você está com o pré-obesidade tendo um IMC de " + resultado, Toast.LENGTH_LONG).show();
            } else if (resultado >= 30 && resultado < 35) {
                Toast.makeText(HomeActivity.this, "Você está com obesidade de Grau 1 tendo um IMC de " + resultado, Toast.LENGTH_LONG).show();
            } else if (resultado >= 35 && resultado < 40) {
                Toast.makeText(HomeActivity.this, "Você está com obesidade Grau 2 tendo um IMC de "+ resultado, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(HomeActivity.this, "Você está com obesidade Grau 3 tendo um IMC de "+ resultado, Toast.LENGTH_LONG).show();
            }
        }
    }
}