package br.feevale.freqmax;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Atleta> atletas = new ArrayList<>();
    AtletaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#504C4C")));
        setContentView(R.layout.activity_main);

        ListView listAtletas = findViewById(R.id.listAtletas);
        adapter = new AtletaAdapter(atletas, getBaseContext());
        listAtletas.setAdapter(adapter);
    }

    public void btAddCalc(View v){
        EditText nome = findViewById(R.id.editTextNome);
        EditText idade = findViewById(R.id.editTextIdade);

        Atleta a = new Atleta();

        if (a.valid(nome.getText().toString(), idade.getText().toString())) {
            atletas.add(a);
            Collections.sort(atletas);
            adapter.notifyDataSetChanged();

            nome.setText("");
            idade.setText("");
            nome.requestFocus();
        } else {
            Toast.makeText(getBaseContext(), "Informações inválidas!", Toast.LENGTH_LONG).show();
        };
    }
}