package com.example.myweatherbase.activities;


    import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

    public class MainActivity extends BaseActivity implements CallInterface {


        private Root root;
        private RecyclerView recycler;


            private TextView txtView ;
        private TextView textViewDay;
        private TextView textViewDayOfWeek;
        private ImageView imageView;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
              setContentView(R.layout.recycler_view);
              recycler=findViewById(R.id.recycler);
/*
              txtView = findViewById(R.id.txtViewStateHeaven);
              textViewDay = findViewById(R.id.textViewDay);
              textViewDayOfWeek = findViewById(R.id.textViewDayOfWeek);
              txtView = findViewById(R.id.txtViewStateHeaven);
              imageView = findViewById(R.id.imageView);

 */
          showProgress();
        executeCall(this);

        // Mostramos la barra de progreso y ejecutamos la llamada a la API

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
            AdaptarRecyclerView adaptador=new AdaptarRecyclerView(this,root);
            recycler.setAdapter(adaptador);
            recycler.setLayoutManager(new LinearLayoutManager(this));

            /*
            txtView.setText(root.list.get(0).weather.get(0).description);
            ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(0).weather.get(0).icon + Parameters.ICON_URL_POST, imageView);

            Date date = new Date((long)root.list.get(0).dt*1000);
            SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("E");
            SimpleDateFormat dateDay = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
            textViewDayOfWeek.setText(dateDayOfWeek.format(date));
            textViewDay.setText(dateDay.format(date));

             */
        }

}
