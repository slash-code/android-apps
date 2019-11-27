package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvScreen;
    double num1, num2, resultado, memoria;
    String operador, operacion;
    int cont=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bt0 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"0");
    }
    public void bt1 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"1");
    }
    public void bt2 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"2");
    }
    public void bt3 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"3");
    }
    public void bt4 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"4");
    }
    public void bt5 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"5");
    }
    public void bt6 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"6");
    }
    public void bt7 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"7");
    }
    public void bt8 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"8");
    }
    public void bt9 (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+"9");
    }
    public void btPunto (View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(tvScreen.getText()+".");
    }
     public void CapturaNum1(View view){
        tvScreen=(TextView) findViewById(R.id.tvPantalla);
        num1=Double.parseDouble(tvScreen.getText().toString());
        tvScreen.setText(" ");
    }
    public void Sumar(View view){
        operador="+";
        CapturaNum1(view);
    }
    public void Restar(View view){
        operador="-";
        CapturaNum1(view);
    }
    public void Multiplicar(View view){
        operador="*";
        CapturaNum1(view);
    }
    public void Dividir(View view){
        operador="/";
        CapturaNum1(view);
    }
    public void Potencia(View view){
        operador="exp";
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        try{
            num1=Double.parseDouble(tvScreen.getText().toString());
            tvScreen.setText("");

        }catch(NumberFormatException nfe){}
    }
    public void Raiz(View view){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        try{
            num1=Double.parseDouble(tvScreen.getText().toString());
            resultado=Math.sqrt(num1);
            tvScreen.setText(String.valueOf(resultado));
        }catch (NumberFormatException nfe){ }
    }
    public void Borrar(View view){
        String s=""+resultado;
        int size=s.length();
        if (!tvScreen.getText().equals(" ") ){
            tvScreen.setText(tvScreen.getText().subSequence(0,tvScreen.getText().length()-1));
        }
    }
    public void Limpiar(View view){
        num1=0.0;
        num2=0.0;
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        tvScreen.setText(" ");
    }
    public void GuardaOperacion(){
        tvScreen=(TextView)findViewById(R.id.tvPantalla);
        num2=Double.parseDouble(tvScreen.getText().toString());
        operacion=""+num1+" "+ operador + num2;

    }
    public void btMemoria(View view){
        if(cont==0){
            memoria=resultado;
            cont=1;
        }else{
            cont=0;
            tvScreen.setText(""+memoria);
            num2=memoria;
        }
    }
    public void bIgual(View view){
        try {
            tvScreen = (TextView) findViewById(R.id.tvPantalla);
            num2 = Double.parseDouble(tvScreen.getText().toString());
            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    resultado = num1 / num2;
                    break;
                case "exp":
                    tvScreen = (TextView) findViewById(R.id.tvPantalla);
                    num2 = Double.parseDouble(tvScreen.getText().toString());
                    tvScreen.setText(" ");
                    resultado = Math.pow(num1, num2);
                    break;

                default:
                    Toast.makeText(MainActivity.this, "Operacion Errada", Toast.LENGTH_SHORT).show();

            }
            GuardaOperacion();
            tvScreen.setText(" " + operacion + "\n = " + resultado);
        }catch(NumberFormatException nfe){}
    }
    public void btAutor(View view){
        Intent miIntent=new Intent(MainActivity.this, AutorActivity.class);

        Bundle miBundle = new Bundle();
        miBundle.putString("calculo", operacion);
        miBundle.putDouble("res", resultado);

        miIntent.putExtras(miBundle);
        //miIntent.putExtra("res",resultado);
        startActivity(miIntent);
    }




}
