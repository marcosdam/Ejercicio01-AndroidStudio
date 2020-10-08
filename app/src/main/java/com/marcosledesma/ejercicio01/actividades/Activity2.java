package com.marcosledesma.ejercicio01.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.marcosledesma.ejercicio01.R;
import com.marcosledesma.ejercicio01.modelos.Ordenador;

public class Activity2 extends AppCompatActivity {

    private EditText txtMarca, txtModelo, txtProcesador, txtPulgadas, txtTamanioDisco, txtTamanioRAM;
    private Switch swSSD;
    private Button btnCancelar, btnGuardar;

    private Ordenador ordenador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // 1. INICIALIZAR
        inicializarVariables();
        // 2. RECIBIR INTENT DEL MAIN CON EL ORDENADOR
        ordenador = getIntent().getExtras().getParcelable("ORDENADOR");
        // 3. DAR VALORES A LOS txtMarca, etc con la info recibida de Ordenador
        if(ordenador != null){
            inicializaValores();
        }
        else{
            Toast.makeText(this, "No tengo datos del ordenador", Toast.LENGTH_LONG).show();
        }

        // 4. CREAR EVENTOS DE LOS BOTONES (CANCELAR Y GUARDAR)
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED); // Para que el Main lo recoja y no haga nada
                finish();   // Cierra la actividad2
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Actualiza el ordenador en función a los datos de la Activity2
                ordenador = new Ordenador();
                ordenador.setMarca(txtMarca.getText().toString());
                ordenador.setModelo(txtModelo.getText().toString());
                ordenador.setProcesador(txtProcesador.getText().toString());
                ordenador.setPulgadas(Float.parseFloat(txtPulgadas.getText().toString()));
                ordenador.setTamanioDisco(Integer.parseInt(txtTamanioDisco.getText().toString()));
                ordenador.setTamanioRam(Integer.parseInt(txtTamanioRAM.getText().toString()));
                ordenador.setSsd(swSSD.isChecked());

                // DEVOLVER EL ORDENADOR ACTUALIZADO AL MAIN (INTENT Y BUNDLE)
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable("ordenador", ordenador);   // Este es un bundle distinto, por eso en minúscula
                intent.putExtras(bundle);

                setResult(RESULT_OK, intent);
                finish();   // Cierra la actividad2
            }
        });

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
        txtMarca = findViewById(R.id.txtMarcaAct2);
        txtModelo = findViewById(R.id.txtModeloAct2);
        txtProcesador = findViewById(R.id.txtProcesadorAct2);
        txtPulgadas = findViewById(R.id.txtPulgadasAct2);
        txtTamanioDisco = findViewById(R.id.txtTamanioDiscoAct2);
        txtTamanioRAM = findViewById(R.id.txtTamanioRamAct2);
        btnCancelar = findViewById(R.id.btnCancelarAct2);
        btnGuardar = findViewById(R.id.btnGuardarAct2);
        swSSD = findViewById(R.id.swSSDAct2);
    }
}