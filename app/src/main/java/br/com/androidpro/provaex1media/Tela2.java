package br.com.androidpro.provaex1media;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    TextView mediaFinal, situacaoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mediaFinal = (TextView)findViewById(R.id.mediaFinalTextView);
        situacaoFinal = (TextView)findViewById(R.id.situacaoFinalTextView);

        Intent it = getIntent();
        if(it != null) {
            Double nota1 = it.getDoubleExtra("media1", 0.0);
            Double nota2 = it.getDoubleExtra("media2", 0.0);
            int freq = it.getIntExtra("frequencia", 0);

            Log.d("mediaCv2tela", nota1.toString());
            Log.d("mediaCv2tela", nota2.toString());

            calculaMediaEsituacaoFinal(nota1, nota2, freq);
        }

    }

    public void calculaMediaEsituacaoFinal(Double media1, Double media2, int frequencia) {
        Double MF = ((media1+media2)/2.0);
        Log.d("mediaCv2", MF.toString());
        String CF = "";

        if(MF >= 7.0 && frequencia >= 75) {
            CF = "Aprovado.";
        } else if(MF >= 4.0 && MF <= 6.9 && frequencia >= 75) {
            CF = "Final.";
        } else if(frequencia < 75) {
            CF = "Reprovado por falta.";
        } else if(MF < 4.0) {
            CF = "Reprovado por nota.";
        }

        mediaFinal.setText(String.valueOf(MF));
        situacaoFinal.setText(CF);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
