package com.example.atividade;

import android.os.Parcel;
import android.os.Parcelable;

public class Evento implements Parcelable {
    private String nome;
    private String local;
    private String tipo;
    private String data;


    public Evento(String nome, String local, String tipo, String data) {
        this.nome = nome;
        this.local = local;
        this.tipo = tipo;
        this.data = data;
    }

    public Evento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Evento(Parcel in) {
        // Esse construtor apesar de nao ser requerido pela interface,
        // e necessario por causa do protocolo implicito do Parcelable
        // Lembrar da ordem que foi escrita no writeToParcel!!
         nome = in.readString();
         local = in.readString();
         tipo = in.readString();
         data = in.readString();
        // Demais campos
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        // Serializa os campos da sua classe,
        // lembrando que essa ordem e importante no construtor
        dest.writeString(nome);
        dest.writeString(local);
        dest.writeString(tipo);
        dest.writeString(data);
    }

    // Como parte do contrato implicito,
    // sua classe precisa de um atributo estatico chamado "CREATOR"

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Evento createFromParcel(Parcel in) {
            return new Evento(in);
        }

        public Evento[] newArray(int size) {
            return new Evento[size];
        }
    };
}




