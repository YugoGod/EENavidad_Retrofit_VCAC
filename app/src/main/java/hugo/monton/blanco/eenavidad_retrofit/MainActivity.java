package hugo.monton.blanco.eenavidad_retrofit;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import hugo.monton.blanco.eenavidad_retrofit.adapters.PersonajeAdapter;
import hugo.monton.blanco.eenavidad_retrofit.conexiones.ApiConexiones;
import hugo.monton.blanco.eenavidad_retrofit.conexiones.RetrofitObject;
import hugo.monton.blanco.eenavidad_retrofit.databinding.ActivityMainBinding;
import hugo.monton.blanco.eenavidad_retrofit.modelos.GeneralDisney;
import hugo.monton.blanco.eenavidad_retrofit.modelos.PersonajeDisney;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    private List<PersonajeDisney> personajesList;
    private PersonajeAdapter adapter;
    private RecyclerView.LayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        personajesList = new ArrayList<>();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        adapter = new PersonajeAdapter(MainActivity.this, personajesList, R.layout.general_view_model);
        lm = new LinearLayoutManager(this); // El 'context' puede ser tanto 'MainActivity.this' como 'this'.

        binding.contentMain.contenedor.setAdapter(adapter);
        binding.contentMain.contenedor.setLayoutManager(lm);

        doGetPersonajes();


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void doGetPersonajes() {
        Retrofit retrofit = RetrofitObject.getConnection();
        ApiConexiones api = retrofit.create(ApiConexiones.class);

        Call<GeneralDisney> getUsuarios = api.getPersonajes();

        getUsuarios.enqueue(new Callback<GeneralDisney>() {
            @Override
            public void onResponse(Call<GeneralDisney> call, Response<GeneralDisney> response) {
                if (response.isSuccessful()){
                    if (response.code() == HttpURLConnection.HTTP_OK){
                        Toast.makeText(MainActivity.this, "Funciona.", Toast.LENGTH_SHORT).show();
                        if (response.body() != null){
                            personajesList.addAll(response.body().getData());
                            adapter.notifyItemRangeInserted(0, personajesList.size());
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Algo ha fallado." + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "No ha salido bien.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GeneralDisney> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexión.", Toast.LENGTH_SHORT).show();
                Log.e("Failure", t.getMessage());
            }
        });
    }
}