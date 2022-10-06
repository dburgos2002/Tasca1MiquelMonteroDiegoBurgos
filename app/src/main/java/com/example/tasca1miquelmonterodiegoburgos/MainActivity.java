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

    final double[] secImpr = {0};
    final double[] minImpr = {0};
    final double[] horImpr = {0};
    final double[] anyImpr = {0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final double[] valor = {0};
        final String[] unitat = {""};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et1 = (EditText)findViewById(R.id.valor);
        final Spinner sp1 = (Spinner)findViewById(R.id.unitats);

        final TextView sec = (TextView)findViewById(R.id.seg);
        sec.setText(String.valueOf(secImpr[0]));
        final TextView min = (TextView)findViewById(R.id.min);
        min.setText(String.valueOf(minImpr[0]));
        final TextView hor = (TextView)findViewById(R.id.hor);
        hor.setText(String.valueOf(horImpr[0]));
        final TextView any = (TextView)findViewById(R.id.an);
        any.setText(String.valueOf(anyImpr[0]));

        Button button= (Button) findViewById(R.id.convertir);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                valor[0] = Integer.parseInt(et1.getText().toString());
                unitat[0] = sp1.getSelectedItem().toString();
                System.out.println("Valor es: " + valor[0] + "\n La unitat és: " + unitat[0]);

                secImpr[0] = calcularSec(unitat[0], valor[0]);
                sec.setText(String.valueOf(secImpr[0]));

                minImpr[0] = calcularMin(unitat[0], valor[0]);
                min.setText(String.valueOf(minImpr[0]));

                horImpr[0] = calcularHor(unitat[0], valor[0]);
                hor.setText(String.valueOf(horImpr[0]));

                anyImpr[0] = calcularAny(unitat[0], valor[0]);
                any.setText(String.valueOf(anyImpr[0]));
            }
        });
    }

    public double calcularSec(String unitat, double valor) {

        switch (unitat) {
            case "Segons":
                return valor;
            case "Minuts":
                return valor*60;
            case "Hores":
                return valor*3600;
            case "Anys":
                return valor*31536000;
            default:
                return 0;
        }

    }

    public double calcularMin(String unitat, double valor) {

        switch (unitat) {
            case "Segons":
                return valor/60;
            case "Minuts":
                return valor;
            case "Hores":
                return valor*60;
            case "Anys":
                return valor*525600;
            default:
                return 0;
        }

    }

    public double calcularHor(String unitat, double valor) {

        switch (unitat) {
            case "Segons":
                System.out.println("El resultado es: " + valor/3600);
                return valor/3600;
            case "Minuts":
                return valor/60;
            case "Hores":
                return valor;
            case "Anys":
                return valor*8760;
            default:
                return 0;
        }

    }

    public double calcularAny(String unitat, double valor) {

        switch (unitat) {
            case "Segons":
                return valor/31536000;
            case "Minuts":
                return valor/525600;
            case "Hores":
                return valor/8760;
            case "Anys":
                return valor;
            default:
                return 0;
        }

    }

}