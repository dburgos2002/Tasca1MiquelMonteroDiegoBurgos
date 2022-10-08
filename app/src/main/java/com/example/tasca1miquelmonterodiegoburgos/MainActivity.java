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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creem les variables on s'imprimeixen els resultats
    final double[] secImpr = {0};
    final double[] minImpr = {0};
    final double[] horImpr = {0};
    final double[] anyImpr = {0};
    final String [] unitats = getResources().getStringArray(R.array.lenguajes);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Creem les variables en les que es guardarà tant la unitat com el valor introduït
        final double[] valor = {0};
        final String[] unitat = {""};

        //Assignem la vista
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarem el valor i la unitat de la vista
        final EditText et1 = (EditText)findViewById(R.id.valor);
        final Spinner sp1 = (Spinner)findViewById(R.id.unitats);

        //Declarem els diferents TextViews on es veuran els resultats de cada unitat
        final TextView sec = (TextView)findViewById(R.id.seg);
        //Li assignem el valor de les vairables anteriorment creades.
        sec.setText(String.valueOf(secImpr[0]));

        //Repetim això amb la resta d'unitats
        final TextView min = (TextView)findViewById(R.id.min);
        min.setText(String.valueOf(minImpr[0]));

        final TextView hor = (TextView)findViewById(R.id.hor);
        hor.setText(String.valueOf(horImpr[0]));

        final TextView any = (TextView)findViewById(R.id.an);
        any.setText(String.valueOf(anyImpr[0]));

        //Creem un listener per al botó de convertir
        Button button= (Button) findViewById(R.id.convertir);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Assignem el valor obtingut en la vista a les variables anteriorment creades
                valor[0] = Integer.parseInt(et1.getText().toString());
                unitat[0] = sp1.getSelectedItem().toString();

                //Cridem a la funció que fa els calculs
                secImpr[0] = calcularSec(unitat[0], valor[0]);
                //Imprimim el resultat en la vista
                sec.setText(String.valueOf(secImpr[0]));

                //Repetim el procés per a cada unitat
                minImpr[0] = calcularMin(unitat[0], valor[0]);
                min.setText(String.valueOf(minImpr[0]));

                horImpr[0] = calcularHor(unitat[0], valor[0]);
                hor.setText(String.valueOf(horImpr[0]));

                anyImpr[0] = calcularAny(unitat[0], valor[0]);
                any.setText(String.valueOf(anyImpr[0]));
            }
        });
    }

    //Funció per a calcular els segons
    public double calcularSec(String unitat, double valor) {

        if (valor >= 0){
            //Fem servir un switch que depenent de la unitat retorna un resultat o un altre
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
                    Toast.makeText(getApplicationContext(), "Selecciona una unitat", Toast.LENGTH_SHORT).show();
                    return 0;
            }
        } else {
            Toast.makeText(getApplicationContext(), "El temps no pot ser negatiu", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    //Funció per a calcular els minuts
    public double calcularMin(String unitat, double valor) {

        //Fem servir un switch que depenent de la unitat retorna un resultat o un altre
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
                //Generem un pop up per si l'usuari no ha indicat la unitat
                Toast.makeText(getApplicationContext(), "Selecciona una unitat", Toast.LENGTH_SHORT).show();
                return 0;
        }

    }

    //Funció per a calcular les hores
    public double calcularHor(String unitat, double valor) {

        //Fem servir un switch que depenent de la unitat retorna un resultat o un altre
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
                //Generem un pop up per si l'usuari no ha indicat la unitat
                Toast.makeText(getApplicationContext(), "Selecciona una unitat", Toast.LENGTH_SHORT).show();
                return 0;
        }

    }

    //Funció per a calcular els anys
    public double calcularAny(String unitat, double valor) {

        //Fem servir un switch que depenent de la unitat retorna un resultat o un altre
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
                //Generem un pop up per si l'usuari no ha indicat la unitat
                Toast.makeText(getApplicationContext(), "Selecciona una unitat", Toast.LENGTH_SHORT).show();
                return 0;
        }

    }

}