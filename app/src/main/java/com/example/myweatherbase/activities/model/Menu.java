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
                        RepositoryCoord.getInstance().getAll());

        spinner.setAdapter(adaptadorSpinner);




        enviar.setOnClickListener(view->{
        Intent intent=new Intent();
            City city=(City) spinner.getSelectedItem();
         //   String name=city.name.toString();
            intent.putExtra("coordenadas",city.getCoord().toString());
         //   intent.putExtra("nombre_ciudad",city.getName());
            finish();

          //  startActivity(intent);

        });

    }


}
