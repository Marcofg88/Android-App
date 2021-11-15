package com.example.cambiaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class Activity2 extends AppCompatActivity {
    private String nomeUtente1="Benvenuto ";
    private String nomeUtente2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2); //setto nel content view il layout della seconda activity
        nomeUtente1 = nomeUtente1.concat(getIntent().getStringExtra("nome1"));//prendo il valore salvato nell extra dell intent e lo concateno con la stringa gia presente
        nomeUtente2 = getIntent().getStringExtra("nome2");

        TextView tx1 = findViewById(R.id.text1);
        tx1.setText(nomeUtente1); //setto il valore preso prima

        TextView tx2 = findViewById(R.id.text3);
        tx2.setText(nomeUtente2);
    }
}