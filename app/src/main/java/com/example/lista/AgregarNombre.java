package com.example.lista;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarNombre extends AppCompatActivity implements View.OnClickListener {
    int i = 0;
    Handler h = new Handler();
    boolean isActivo = false;
    ProgressBar proBar;
    TextView porcentaje;
    TextView Nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nombre);

        porcentaje = findViewById(R.id.porcentaje);
        proBar = findViewById(R.id.proBar);
        Nombre = findViewById(R.id.txtNombre);

    }

    @Override
    public void onClick(View view) {
        if(Nombre.getText().toString().isEmpty()){
            Toast.makeText(this, "Digite un nombre", Toast.LENGTH_SHORT).show();
        }else{
            if( view.getId()== R.id.btnProcesarInfo) {
                    Barrer();

             }
        }

    }

    private void Barrer(){
        Thread hr = new Thread(new Runnable() {
            @Override
            public void run() {
                while(i <= 100){
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            porcentaje.setText(i +" %");
                            proBar.setProgress(i);
                        }
                    });
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i == 100) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                MainActivity.Lista.add(Nombre.getText().toString());
                                AlertDialog.Builder Abuilder = new AlertDialog.Builder(AgregarNombre.this);
                                Abuilder.setTitle("Se agrego con exito:");
                                Abuilder.setMessage("Desea agregar otro usuario?");
                                Abuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Nombre.setText("");
                                        proBar.setProgress(0);
                                        i=0;
                                        porcentaje.setText("");
                                        isActivo=false;
                                    }
                                });
                                Abuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        finish();
                                    }
                                });
                                Abuilder.show();
                                //Toast.makeText(getApplicationContext(),"Se agrego correctamente : " + Nombre.getText().toString() , Toast.LENGTH_LONG).show();
                                //finish();
                            }
                        });
                    }
                    i++;
                }
            }
        });
        hr.start();

    }


}
