package com.example.atividade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner sprn;
    String [] Locais = {"Fortaleza", "Quixadá", "Sobral"};
    Evento evento = new Evento();
    RadioGroup radioGroup;
    ArrayList<Evento> eventos = new ArrayList<Evento>();
    MediaPlayer mSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSound = MediaPlayer.create(this, R.raw.lvlup);
        // ################### SPINNER #################
        sprn = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, Locais);

        sprn.setAdapter(adapter);
        sprn.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = sprn.getSelectedItemPosition();
                        Toast.makeText(getApplicationContext(),"Local do Evento "+Locais[+position], Toast.LENGTH_LONG).show();
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }

                }
        );
        //################## SPINNER FIM ##########################

        /*################## RADIO BUTTON ###################### */
        /* Initialize Radio Group and attach click handler */
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        /* Attach CheckedChangeListener to radio group */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if((null != rb) && (checkedId > -1)){
                    Toast.makeText(MainActivity.this, "O evento será "+rb.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        /*################## RADIO BUTTON FIM ###################### */

    }

    // ######################## MENU #########################
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Sair :
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //####################### MENU FIM #######################
    /* ###################### SALVAR INICIO ##################### */
    public void SalvarEvento(View view){
        Evento evento = new Evento();
        EditText eNome = (EditText)findViewById(R.id.editNome);
        EditText eData = (EditText)findViewById(R.id.eData);
        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        evento.setNome(eNome.getText().toString());
        evento.setLocal(Locais[sprn.getSelectedItemPosition()]);
        evento.setTipo(rb.getText().toString());
        evento.setData(eData.getText().toString());
        eventos.add(evento);
        mSound.start();
        Log.d("TESTE EVENTO SALVO", "Evento "+evento.getNome()+" "+evento.getLocal()+" "+evento.getTipo());

    }
    /* ###################### SALVAR FIM ##################### */

    /* ###################### LISTAR INICIO ##################### */
    public void Listar(View view){
        Intent i = new Intent(this, Lista.class);

        i.putParcelableArrayListExtra("eventos", eventos);

        startActivity(i);
    }
    /* ###################### SALVAR FIM ##################### */
}
