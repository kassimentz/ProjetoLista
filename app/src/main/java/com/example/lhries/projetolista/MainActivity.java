package com.example.lhries.projetolista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<String> listaPaises;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPaises = new ArrayList<String>();
        listaPaises.add("Argentina");
        listaPaises.add("Brasil");
        listaPaises.add("Estados Unidos");
        listaPaises.add("Paraguai");
        listaPaises.add("Uruguai");

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listaPaises
        );

        ListView listView = (ListView) findViewById(R.id.main_listview_paises);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    public void addPais(View view){
        EditText textoPais = (EditText) findViewById(R.id.main_texto_pais);
        listaPaises.add(textoPais.getText().toString());
        adapter.notifyDataSetChanged();
        textoPais.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        Toast.makeText(this, listaPaises.get(pos), Toast.LENGTH_SHORT).show();
    }
}
