// Miquel Montero i Diego Burgos
package com.example.tasca1miquelmonterodiegoburgos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final int[] valor = {0};
        final String[] unitat = {""};

        int secImpr = 0;
        int minImpr = 0;
        int horImpr = 0;
        int anyImpr = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et1 = (EditText)findViewById(R.id.valor);
        final Spinner sp1 = (Spinner)findViewById(R.id.unitats);

        final TextView sec = (TextView)findViewById(R.id.seg);
        sec.setText(String.valueOf(secImpr));
        final TextView min = (TextView)findViewById(R.id.min);
        min.setText(String.valueOf(minImpr));
        final TextView hor = (TextView)findViewById(R.id.hor);
        hor.setText(String.valueOf(horImpr));
        final TextView any = (TextView)findViewById(R.id.an);
        any.setText(String.valueOf(anyImpr));

        Button button= (Button) findViewById(R.id.convertir);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                valor[0] = Integer.parseInt(et1.getText().toString());
                unitat[0] = sp1.getSelectedItem().toString();
                System.out.println("Valor es: " + valor[0] + "\n La unitat és: " + unitat[0]);
            }
        });
    }
}