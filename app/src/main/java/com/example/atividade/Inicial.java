package com.example.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

public class Inicial extends AppCompatActivity {

    MediaPlayer mSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        mSound = MediaPlayer.create(this, R.raw.skyrim);
        mSound.start();

    }

    public void Sair(View view){
        mSound.stop();
        finishAffinity();
    }
    public void Cadastrar(View view){
        mSound.stop();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
