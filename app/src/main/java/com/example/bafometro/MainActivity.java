package com.example.bafometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_PESO = "com.example.Bafometro.PESO";
    public static final String EXTRA_SEXO = "com.example.Bafometro.SEXO";
    public static final String EXTRA_COPOS = "com.example.Bafometro.COPOS";
    public static final String EXTRA_JEJUM = "com.example.Bafometro.JEJUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ButtonDados(View view) {
        final EditText digPeso = (EditText) findViewById(R.id.digPeso);
        final EditText digSexo = (EditText) findViewById(R.id.digSexo);
        final EditText digCopos = (EditText) findViewById(R.id.digCopos);
        final EditText digJejum = (EditText) findViewById(R.id.digJejum);

        String peso = digPeso.getText().toString();
        String sexo = digSexo.getText().toString();
        String copos = digCopos.getText().toString();
        String jejum = digJejum.getText().toString();

        Intent it = new Intent(getBaseContext(), Tela2.class);

        it.putExtra(EXTRA_PESO, peso);
        it.putExtra(EXTRA_SEXO, sexo);
        it.putExtra(EXTRA_COPOS, copos);
        it.putExtra(EXTRA_JEJUM, jejum);

        startActivityForResult(it, 10);
    }
    @Override
    protected void onActivityResult(int codigoRequisicao, int codigoResultado, Intent it) {
        super.onActivityResult(codigoRequisicao, codigoResultado, it);
        if (it == null) {
            Toast.makeText(this, "NENHUM VALOR! ", Toast.LENGTH_LONG).show();
            return;
        } else if (codigoRequisicao == 10) {
            String taxa = it.getStringExtra("tx");
            String classif = it.getStringExtra("classif");
            if(codigoResultado==1){
                Toast.makeText(this, "Taxa de Alcoolemia: " + taxa + "\nClassificação: " + classif + "\n", Toast.LENGTH_LONG).show();
            }
        }
    }
}