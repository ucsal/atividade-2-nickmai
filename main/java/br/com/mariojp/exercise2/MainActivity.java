package br.com.mariojp.exercise2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String txt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null) {
            this.txt = savedInstanceState.getString("nomeAtual");
        } else {
            this.txt = new String();
        }


        TextView textOi = findViewById(R.id.textView);
        textOi.setText("Oi");

        Intent outraIntent = getIntent();
        String nome = outraIntent.getStringExtra("novoNome");
        txt = nome;
        if (nome == null || nome.equals("")) {
            textOi.setText(textOi.getText().toString() + "!");
        }else{
            textOi.setText(textOi.getText().toString() +", "+ nome + "!");
        }

    }

    public void clickTrocar(View botao){
        Intent intent = new Intent(MainActivity.this, OutraActivity.class);
        intent.putExtra("atual", txt);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nomeAtual", txt);
    }

}
