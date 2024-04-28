package com.example.myweatherbase.activities;


    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.provider.DocumentsContract;
    import android.widget.Toast;

    import androidx.activity.result.ActivityResult;
    import androidx.activity.result.ActivityResultCallback;
    import androidx.activity.result.ActivityResultLauncher;
    import androidx.activity.result.contract.ActivityResultContracts;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
    import com.example.myweatherbase.activities.model.City;
    import com.example.myweatherbase.activities.model.Coord;
    import com.example.myweatherbase.activities.model.Menu;
    import com.example.myweatherbase.activities.model.RepositoryCoord;
    import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
    import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends BaseActivity implements CallInterface {


        private Root root;
        private RecyclerView recycler;
//        private TextView txtView ;
//        private TextView textViewDay;
//        private TextView textViewDayOfWeek;
//        private ImageView imageView;
    private FloatingActionButton anyiadir;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
              setContentView(R.layout.main_activity);
              recycler=findViewById(R.id.recycler);
              anyiadir=findViewById(R.id.addWeather);

          showProgress();
        executeCall(this);

              ActivityResultLauncher<Intent> activityResultLauncher =
                      registerForActivityResult(
                              new ActivityResultContracts.StartActivityForResult(),
                              new ActivityResultCallback<ActivityResult>() {
                                  @Override
                                  public void onActivityResult(ActivityResult result) {
                                      Intent data=result.getData();

                                      String coord= data.getExtras().getString("coordenadas");
                                      root=Connector.getConector().get(Root.class,coord);
                                      //   RepositoryCoord.getInstance().add(coord);
                                  }


                              }
                      );
              anyiadir.setOnClickListener(view -> {
                  Intent intent = new Intent(this, Menu.class);
                  activityResultLauncher.launch(intent);

              });

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

        }


}
