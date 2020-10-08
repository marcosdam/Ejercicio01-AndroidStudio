package com.marcosledesma.ejercicio01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.marcosledesma.ejercicio01.actividades.Activity2;
import com.marcosledesma.ejercicio01.modelos.Ordenador;

public class MainActivity extends AppCompatActivity {

    private Ordenador ordenador;
    private final int ACTIVIDAD_2 = 2;

    private EditText txtMarca, txtModelo, txtProcesador, txtPulgadas, txtTamanioDisco, txtTamanioRAM;
    private Switch swSSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVariables();
    }

    public void clickBoton(View botonClicked){
        Button boton = (Button) botonClicked;

        Intent intent = null;

        Bundle bundle = new Bundle();

        int actividad = 0;

        switch (boton.getId())
        {
            case R.id.btnAct2Main:
                intent = new Intent(MainActivity.this, Activity2.class);
                // Recibir ordenador (lo "guardamos" en el bundle)
                bundle.putParcelable("ORDENADOR", ordenador);
                actividad = ACTIVIDAD_2;
                break;
        }
        intent.putExtras(bundle);   // Cargamos info que hay que llevar a Activity2
        // startActivityForResult (saber a qué actividad he enviado, quién me tiene que contestar)
        startActivityForResult(intent, actividad);
    }

    // Aquí llegamos cuando la actividad 2 se ha cerrado
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Si vengo de la Activity2 hago esto
        if (requestCode == ACTIVIDAD_2){
            if(resultCode == RESULT_OK)
            {
                ordenador = data.getExtras().getParcelable("ordenador");    // Aquí data es el intent de Activity2
                Toast.makeText(this, ordenador.toString(), Toast.LENGTH_LONG).show();

                inicializaValores();

            }
            else {
                Toast.makeText(this, "Se ha cancelado", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void inicializaValores() {
        txtMarca.setText(ordenador.getMarca());
        txtModelo.setText(ordenador.getModelo());
        txtProcesador.setText(ordenador.getProcesador());
        txtPulgadas.setText(String.valueOf(ordenador.getPulgadas()));
        txtTamanioDisco.setText(String.valueOf(ordenador.getTamanioDisco()));
        txtTamanioRAM.setText(String.valueOf(ordenador.getTamanioRam()));
        swSSD.setChecked(ordenador.isSsd());
    }

    private void inicializarVariables() {
        txtMarca = findViewById(R.id.txtMarcaMain);
        txtModelo = findViewById(R.id.txtModeloMain);
        txtProcesador = findViewById(R.id.txtProcesadorMain);
        txtPulgadas = findViewById(R.id.txtPulgadasMain);
        txtTamanioDisco = findViewById(R.id.txtTamanioDiscoMain);
        txtTamanioRAM = findViewById(R.id.txtTamanioRamMain);
        swSSD = findViewById(R.id.swSSDMain);
    }
}