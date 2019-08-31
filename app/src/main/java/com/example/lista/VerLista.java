package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VerLista extends AppCompatActivity {
    public ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);
        listView=findViewById(R.id.listaNombre);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MainActivity.Lista));
        listView.deferNotifyDataSetChanged();

    }
}
