package br.feevale.freqmax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class AtletaAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<Atleta> atletas;

    AtletaAdapter(List<Atleta> atletas, Context ctx) {
        this.atletas = atletas;
        inflater = LayoutInflater.from(ctx);
    }

    public int getCount() {
        return atletas.size();
    }

    public Object getItem(int position) {
        return atletas.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.atleta_item, null);
        TextView txtNome = v.findViewById(R.id.idNome);
        TextView txtFCM = v.findViewById(R.id.idFCM);

        Atleta a = atletas.get(position);
        txtNome.setText(a.getNome());
        txtFCM.setText(a.getFreq().toString());
        return v;
    }
}
