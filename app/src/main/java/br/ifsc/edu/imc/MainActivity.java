package br.ifsc.edu.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText textViewA, textViewP;
ImageView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewA=(EditText)findViewById(R.id.textViewA);
        textViewP=(EditText)findViewById(R.id.textViewP);
        resultado=(ImageView)findViewById(R.id.resultado);
    }

    public void CalcularIMC(View v) {
        float peso=0, altura=0, imc=0;
        if(textViewA.getText().toString().length()>0 && textViewP.getText().toString().length()>0){
            peso = Float.parseFloat(textViewP.getText().toString());
            altura = Float.parseFloat(textViewA.getText().toString());
            if(peso<0 && altura<0) {
                imc = (peso / (altura * altura));
                if (imc <= 18.5) {
                    resultado.setImageResource(R.drawable.abaixopeso);
                } else if (imc >= 18.6 && imc <= 24.9) {
                    resultado.setImageResource(R.drawable.normal);
                } else if (imc >= 25.0 && imc <= 29.9) {
                    resultado.setImageResource(R.drawable.sobrepeso);
                } else if (imc >= 30.0 && imc <= 34.9) {
                    resultado.setImageResource(R.drawable.obesidade1);
                } else if (imc >= 35.0 && imc <= 39.9) {
                    resultado.setImageResource(R.drawable.obesidade2);
                } else if (imc >= 40.0) {
                    resultado.setImageResource(R.drawable.obesidade3);
                }
            }
            else{
                Toast.makeText(this, "Peso ou Altura inválidos", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Você deve preencer todos os dados para calcular", Toast.LENGTH_SHORT).show();
        }
    }
}
