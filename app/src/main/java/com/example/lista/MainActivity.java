package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static List<String> Lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.Lista = new ArrayList<>();
     //   this.Lista.add("Brian");


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNombre:{
                Intent nombre= new Intent(this, AgregarNombre.class);
                startActivity(nombre);

             break;
            }
            case R.id.btnLista:{
                if( Lista == null || Lista.size() == 0 ) {
                    Toast.makeText(this, "LA LISTA ESTA VACIA", Toast.LENGTH_SHORT).show();
                }else{
                    Intent lista = new Intent(this, VerLista.class);
                    startActivity(lista);
                }
                break;
            }
            case R.id.btnDatos:{
                Intent datos= new Intent(this, Datos.class);
                startActivity(datos);

                break;
            }



        }

    }
}


