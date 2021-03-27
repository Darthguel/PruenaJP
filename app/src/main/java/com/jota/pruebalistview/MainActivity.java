package com.jota.pruebalistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText textNom, textVal;
    Button bGuardar;
    ListView listarB;

    public ArrayList<String> arrayNombres;
    public ArrayList<Producto> arrayProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNom = (EditText) findViewById(R.id.editNom);
        textVal = (EditText) findViewById(R.id.editVal);
        bGuardar = (Button) findViewById(R.id.boton1);
        listarB = (ListView) findViewById(R.id.lvMostar);

        mostrar();

        // Boton para guardar data en la BD
        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textNom.length() > 0 && textVal.length() > 0)
                {
                    Producto prod = new Producto();
                    Crud selector = new Crud(getApplicationContext());
                    prod.setNombre(textNom.getText().toString());
                    prod.setValor(Integer.parseInt(textVal.getText().toString()));
                    selector.grabar(prod);
                    mostrar();
                }
            }
        });

        listarB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textNom.setText(arrayProd.get(position).getNombre());
                textVal.setText(String.valueOf(arrayProd.get(position).getValor()).toString());
            }
        });
    }

    // Metodo para mostrar en pantalla
    public void mostrar(){
        Crud selector = new Crud( getApplicationContext());
        arrayNombres = selector.cargarNombre();
        arrayProd =selector.mostrarDatos();
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayNombres);
        listarB.setAdapter(adp);
        vaciar();
    }

    // limpiar todo
    public void vaciar(){
        textNom.setText(null);
        textVal.setText(null);
    }



} // FIN DE LA CLASE