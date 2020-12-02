package com.example.bafometro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

    }
    public void ButtonCalcula(View view) {
        Intent it = getIntent();
        String peso = it.getStringExtra(MainActivity.EXTRA_PESO);
        String sexo = it.getStringExtra(MainActivity.EXTRA_SEXO);
        String copos = it.getStringExtra(MainActivity.EXTRA_COPOS);
        String jejum = it.getStringExtra(MainActivity.EXTRA_JEJUM);

        double vlrPeso = Double.parseDouble(peso);
        int vlrCopos = Integer.parseInt(copos);

        double coeficiente = 0;
        if(jejum.equals("s")) {
            if (sexo.equals("m")) coeficiente = 0.7;
            else if (sexo.equals("f")) coeficiente = 0.6;
        }
        else if(jejum.equals("n"))
            coeficiente = 1.1;

        double tx;
        tx = (vlrCopos*4.8)/(vlrPeso*coeficiente);

        String classif;
        if(tx<=0.2) classif = "Pessoa NÃO Alcoolizada";
        else classif = "Pessoa Alcoolizada";
        Intent it2 = new Intent();
        it2.putExtra("tx", String.valueOf(tx));
        it2.putExtra("classif", classif);
        setResult(1,it2);
        finish();
    }
}
