package br.com.mariojp.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OutraActivity extends AppCompatActivity {
    private String txt = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        TextView novoNome = (TextView) findViewById(R.id.editText);

        if (savedInstanceState!=null) {
            novoNome.setText(savedInstanceState.getString("nomeAtual"));
        } else {
            novoNome.setText(new String());
        }


        Intent outraIntent = getIntent();
        String nomeAtual = outraIntent.getStringExtra("atual");
        txt = nomeAtual;
        novoNome.setText(nomeAtual);

    }

    public void clickConfirmar(View confirmButton){
        Intent intent = new Intent(OutraActivity.this, MainActivity.class);

        TextView novoNome = (TextView) findViewById(R.id.editText);

        intent.putExtra("novoNome", novoNome.getText().toString());
        startActivity(intent);
    }

    public void clickCancelar(View cancelButton){
        Intent intent = new Intent(OutraActivity.this, MainActivity.class);
        TextView novoNome = (TextView) findViewById(R.id.editText);
        novoNome.setText("");

        intent.putExtra("novoNome", txt);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView novoNome = (TextView) findViewById(R.id.editText);
        outState.putString("nomeAtual", novoNome.getText().toString());
    }
}
