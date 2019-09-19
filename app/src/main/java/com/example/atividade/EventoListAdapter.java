package com.example.atividade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventoListAdapter extends ArrayAdapter<Evento> {

    private Context mContext;
    int mResource;
    public EventoListAdapter(Context context, int resource, ArrayList<Evento> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String nome = getItem(position).getNome();
        String data = getItem(position).getData();
        String local = getItem(position).getLocal();
        String tipo = getItem(position).getTipo();

        Evento evento = new Evento(nome,local,tipo,data);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvNome = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvData = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvLocal = (TextView) convertView.findViewById(R.id.textView3);
        TextView tvTipo = (TextView) convertView.findViewById(R.id.textView4);

        tvNome.setText(nome);
        tvData.setText(data);
        tvLocal.setText(local);
        tvTipo.setText(tipo);

        return convertView;

    }
}
