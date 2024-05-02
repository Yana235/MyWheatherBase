package com.example.myweatherbase.activities.model;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.MainActivity;

public class Menu extends AppCompatActivity {

    private ImageView bienvenida;
    private TextView textInfo;
    private Spinner spinner;
    private Button enviar;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.menu);
        bienvenida=findViewById(R.id.imageBienvenida);
        textInfo=findViewById(R.id.textViewC);
        spinner=findViewById(R.id.spinner);
        enviar=findViewById(R.id.buttonEnviar);

        ArrayAdapter<City>adaptadorSpinner=
                new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                        RepositoryCity.getInstance().getAll());

        spinner.setAdapter(adaptadorSpinner);


        enviar.setOnClickListener(view->{

                Intent intent = new Intent(this, MainActivity.class);

                City city = (City) spinner.getSelectedItem();
                if (city != null) {
                    String coord=city.getCoord().toString();
                    intent.putExtra("coordenadas", coord);
                    setResult(RESULT_OK,intent);
                    startActivity(intent);
                  //  finish();
                }else {
                    setResult(RESULT_CANCELED);
                    // Indicar que la operación fue cancelada si no se seleccionó ninguna ciudad

                }


        });

    }

}
