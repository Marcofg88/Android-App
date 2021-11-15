package com.example.cambiaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity { // classe primcipale che estende AppCompatActivity che a sua volta estende indirettamente context

// CREO GLI OGGETTI CHE MI SERVIRANNO PER COLLEGARE GLI ELEMENTI PRRESENTI NEL LEYOUT
    private Button button ;
    private String nomeUtente1;
    private String nomeUtente2;
    private TextInputEditText myEditText1; //textinputlayout
    private EditText myEditText2;         // plaintext


    @Override// annotazione che specifica che sto riscrivendo il metodo di una classe madre
    protected void onCreate(Bundle savedInstanceState) { //unico metodo obbligatorio da implementare e primo chiamato all avvio dell app
        super.onCreate(savedInstanceState);//chiama il metodo della classe madre
        setContentView(R.layout.activity_main); // setto nella schermata il layout del activity main
        MediaPlayer motore = MediaPlayer.create(this,R.raw.motore); // collego un file mp3 ,che si trova nelle risorse raw ,all oggetto MediaPlayer
        button =(Button)findViewById(R.id.button); //collego l oggetto bottone in java a quello sulla schermata grafica nel layout
        myEditText1 = findViewById(R.id.nome1); //collego l oggetto textinputlayout in java a quello sulla schermata grafica nel layout
        myEditText1.requestFocus();// il cursore apparirà qui
        myEditText2 = findViewById(R.id.nome2); //collego l oggetto edittext in java a quello sulla schermata grafica nel layout


        button.setOnClickListener(new View.OnClickListener() { //metto il bottone in "ascolto" di un click
            @Override
            public void onClick(View v) { // cosa deve fare quando avviene il click su button
                nomeUtente1 = myEditText1.getEditableText().toString(); //salvo il contenuto dell textinputlayout in una variabile come stringa
                nomeUtente2= myEditText2.getText().toString();
                if(
                        nomeUtente1.equalsIgnoreCase("marco") &&  nomeUtente2.equalsIgnoreCase("lagrasta"))
                {
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);//creo un intent e gli passo l "intenzione" di aprire la seconda activity
                    intent.putExtra("nome1", nomeUtente1); //con un metodo chiave:valore salvo il contenuto della variabile che potrò passare alle altre activity
                    intent.putExtra("nome2", nomeUtente2);
                    startActivity(intent);
                    //é un piccolo messaggio temporaneo che viene visualizzato quando viene premuto il pulsante
                    Toast mess =  Toast.makeText(getBaseContext(),"sei loggato",Toast.LENGTH_SHORT);
                    // creo l oggetto di tipo toast, gli passo il contesto il mess da visualizzare e la durata
                    mess.show();   //  lo visualizzo
                    motore.start(); // avvio l audio
                }//avvio la seconda activity
                else {
                    Toast mess =  Toast.makeText(getBaseContext(),"nome marco  cognome lagrasta",Toast.LENGTH_SHORT);
                    mess.show();
                }




            }
        });
    }

    //HO IMPLEMENTATO TUTTI I METODI DEL CICLO DI VITA DI UN ACTIVITY
    //PER OGNUNO DI ESSI STAMPO UN MESSAGGIO NEI LOG PER CAPIRE QUANDO VENGONO CHIAMATI E IN QUALE ORDINE

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MioLog", "CHIAMATO METODO onStart()"); //si passa all oggetto log un etichetta, con cui cercare appunto questo log ,e il messaggio che verrà visualizzato
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MioLog", "CHIAMATO METODO onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MioLog", "CHIAMATO METODO onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MioLog", "CHIAMATO METODO onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MioLog", "CHIAMATO METODO onRestart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MioLog", "CHIAMATO METODO onDestroy()");
    }
}