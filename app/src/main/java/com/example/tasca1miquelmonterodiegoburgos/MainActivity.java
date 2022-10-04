// Miquel Montero i Diego Burgos
package com.example.tasca1miquelmonterodiegoburgos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompacActivity {

    //Declaració de variables
    String valorS = "";
    int valor = 0;

    //Unitat que tu fiques el temps
    public Spinner unitats;
    public ArrayList<String> lista = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        afegeixValors();
        desplega();
        final TextInputLayout valorSObtingut = (TextInputLayout) (R.id.valorS);
        valorS = valorSObtingut.toString();
        System.out.println(valorS);
    }


    private void afegeixValors() {
        lista.add("Seg");
        lista.add("Min");
        lista.add("Hora");
        lista.add("Any");
    }

    private void desplega() {
        unitats.setOnItemSelectedListener(valor);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitats.setSelection(2);
    }
}