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
        private String coord ="&lat=39.5862518&lon=-0.5411163";
    private FloatingActionButton anyiadir;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
              setContentView(R.layout.main_activity);
              recycler=findViewById(R.id.recycler);
              anyiadir=findViewById(R.id.addWeather);

          showProgress();
        executeCall(this);


              ActivityResultLauncher<Intent> resultLauncher =
                      registerForActivityResult(
                              new ActivityResultContracts.StartActivityForResult(),
                              result-> {



                                 if (result.getResultCode() == Activity.RESULT_OK){
                                      //Intent data = result.getData();

                             // try{
                                  coord = result.getData().getExtras().getString("coordenadas");
                                     executeCall(this);
/*

                              }catch (NullPointerException e){
                                  e.getStackTrace();
                              }

 */

                                  }else if(result.getResultCode() == Activity.RESULT_CANCELED) {
                                     Toast.makeText(this, "Cancelado por el usuario",
                                             Toast.LENGTH_LONG).show();
                                 }


                              }

                      );

                  anyiadir.setOnClickListener(view -> {
                      try{
                      Intent intent = new Intent(this, Menu.class);
                      resultLauncher.launch(intent);
                      }catch(Exception e){
                          e.getStackTrace();
                      }
                  });

         }
         @Override
        public void doInBackground() {

            root = Connector.getConector().get(Root.class,coord);
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
