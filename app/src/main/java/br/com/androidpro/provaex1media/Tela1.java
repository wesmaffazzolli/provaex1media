package br.com.androidpro.provaex1media;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {

    EditText media1, media2, frequencia, nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        media1 = (EditText)findViewById(R.id.media1EditText);
        media2 = (EditText)findViewById(R.id.media2EditText);
        nome = (EditText)findViewById(R.id.nameEditText);
        frequencia = (EditText)findViewById(R.id.frequenciaEditText);

    }

    public void onClick(View view) {

        if(media1 != null && media2 != null && frequencia!= null && nome != null) {
            Double media1cv = Double.parseDouble(media1.getText().toString());
            Double media2cv = Double.parseDouble(media2.getText().toString());
            int frequenciacv = Integer.parseInt(frequencia.getText().toString());
            String nomecv = nome.getText().toString();

            Log.d("mediaCv", media1cv.toString());
            Log.d("mediaCv", media2cv.toString());

            if((media1cv >= 0.0) && (media1cv <= 10.0) && (media2cv >= 0.0) && (media2cv <= 10.0)) {
                if(frequenciacv >= 0 && frequenciacv <= 100) {
                    if(nomecv != "") {
                        Intent it = new Intent(this, Tela2.class);
                        Bundle params = new Bundle();
                        params.putDouble("media1", media1cv);
                        params.putDouble("media2", media2cv);
                        params.putInt("frequencia", frequenciacv);
                        params.putString("nome", nomecv);

                        it.putExtras(params);
                        startActivity(it);
                    } else {
                        Toast.makeText(this, "Digite um nome!!!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "Frequência >= 0 e <= 100!!!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Médias >= 0.0 e <= 10.0!!!", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "Preencha os campos para prosseguir!!!", Toast.LENGTH_LONG).show();
        }
    }
}
