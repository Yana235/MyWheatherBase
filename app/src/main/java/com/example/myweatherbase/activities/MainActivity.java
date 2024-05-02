package com.example.myweatherbase.activities;

    import android.os.Bundle;

    import androidx.recyclerview.widget.DividerItemDecoration;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
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
             setupRecyclerView();
          showProgress();
        executeCall(this);

/*
              ActivityResultLauncher<Intent> resultLauncher =
                      registerForActivityResult(
                              new ActivityResultContracts.StartActivityForResult(),
                              result-> {



                                 if (result.getResultCode() == Activity.RESULT_OK){

                                  coord = result.getData().getExtras().getString("coordenadas");

                                     executeCall(this);

                                  }else if(result.getResultCode() == Activity.RESULT_CANCELED) {
                                     Toast.makeText(this, "No se encuentra dicha ciudad",
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
*/
              Bundle extras = getIntent().getExtras();
              coord = extras.getString("coordenadas");



          }
         @Override
        public void doInBackground() {

            root = Connector.getConector().get(Root.class,coord);
        }

        @Override
        public void doInUI() {

            hideProgress();
            AdaptarRecyclerView adaptador=new AdaptarRecyclerView(this,root);
            recycler.setAdapter(adaptador);
            recycler.setLayoutManager(new LinearLayoutManager(this));

        }
    private void setupRecyclerView() {
       // RecyclerView recyclerView = findViewById(R.id.recycler);
       // recyclerView.setAdapter(new MaterialPaletteAdapter(buildColors()));
          recycler.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(),
                ((LinearLayoutManager) recycler.getLayoutManager()).getOrientation());
        recycler.addItemDecoration(dividerItemDecoration);
    }


}
