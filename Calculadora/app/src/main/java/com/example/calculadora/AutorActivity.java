package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class AutorActivity extends AppCompatActivity {
    TextView tvScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);
        UltimoCalculo(savedInstanceState);
    }


    public void UltimoCalculo(Bundle miBundle){
        tvScreen = (TextView) findViewById(R.id.tvUltimoCalculo);
        miBundle = this.getIntent().getExtras();

        String calc = miBundle.getString("calculo");
        Double resultado = miBundle.getDouble("res");

        if (miBundle != null && calc != null){
            tvScreen.setText("El ultimo calculo realizado fue:\n" +
                    ""+calc+" = "+resultado);
        }else{
            tvScreen.setText("No Se han realizado Calculos");
        }
    }

    public void btVolver(View view){
        Intent miIntent=new Intent(AutorActivity.this, MainActivity.class);
        startActivity(miIntent);

    }

}
