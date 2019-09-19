package com.example.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    private static ArrayList<Evento> eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        ListView mListView = (ListView) findViewById(R.id.listView);
        ArrayList<Evento> eventos = getIntent().getParcelableArrayListExtra("eventos");
        EventoListAdapter   adapter = new EventoListAdapter(this,R.layout.adapter_view_layout,eventos);
        mListView.setAdapter(adapter);

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("long clicked","pos: " + i);

                return true;
            }
        });


    }
}
