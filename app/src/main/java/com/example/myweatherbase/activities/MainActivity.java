package com.example.myweatherbase.activities;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.activities.model.list.List;
import com.example.myweatherbase.activities.model.list.Weather;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

//public class MainActivity extends BaseActivity implements CallInterface {
public class MainActivity extends AppCompatActivity {
    private RecyclerView recycle;
    private TextView city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        recycle = findViewById(R.id.recycler);
        city = findViewById(R.id.textViewCity);
        Root root=new Root();

        AdaptarRecyclerView adaptador = new AdaptarRecyclerView(this);
        recycle.setAdapter(adaptador);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper deslizar = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        int posDestino=target.getAdapterPosition();
                        int posicionInicial=viewHolder.getAdapterPosition();
                        List list =root.list.get(posicionInicial);



                        return true;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                    }
                }

        );


    }
}





    /*
    private TextView txtView ;
    private TextView textViewDay;
    private TextView textViewDayOfWeek;
    private ImageView imageView;
    private Root root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtViewStateHeaven);
        textViewDay = findViewById(R.id.textViewDay);
        textViewDayOfWeek = findViewById(R.id.textViewDayOfWeek);
        imageView = findViewById(R.id.imageView);

        // Mostramos la barra de progreso y ejecutamos la llamada a la API
        showProgress();
        executeCall(this);

    }

    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        root = Connector.getConector().get(Root.class,"&lat=39.5862518&lon=-0.5411163");
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();
        txtView.setText(root.list.get(0).weather.get(0).description);
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(0).weather.get(0).icon + Parameters.ICON_URL_POST, imageView);

        Date date = new Date((long)root.list.get(0).dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("E");
        SimpleDateFormat dateDay = new SimpleDateFormat("EEEE, d MMM yyyy HH:mm");
        textViewDayOfWeek.setText(dateDayOfWeek.format(date));
        textViewDay.setText(dateDay.format(date));
    }
        */




