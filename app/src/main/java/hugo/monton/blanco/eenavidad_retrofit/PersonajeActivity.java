package hugo.monton.blanco.eenavidad_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.HttpURLConnection;

import hugo.monton.blanco.eenavidad_retrofit.conexiones.ApiConexiones;
import hugo.monton.blanco.eenavidad_retrofit.conexiones.RetrofitObject;
import hugo.monton.blanco.eenavidad_retrofit.modelos.GeneralDisney;
import hugo.monton.blanco.eenavidad_retrofit.modelos.PersonajeDisney;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PersonajeActivity extends AppCompatActivity {

    private TextView lblNombre;
    private TextView lblInfo;
    private ImageView imgPj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);

        inicializaVistas();

        if (getIntent().getExtras().getString("ID_PERSONAJE") != null){
            doGetPersonaje(getIntent().getExtras().getString("ID_PERSONAJE"));
            Toast.makeText(this, "ID: " + getIntent().getExtras().getString("ID_PERSONAJE"), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();
        }
    }

    private void inicializaVistas() {
        lblNombre = findViewById(R.id.lblNombrePersonajeActivity);
        lblInfo = findViewById(R.id.lblInfPersonajeActivity);
        imgPj = findViewById(R.id.imgPersonajeActivity);
    }

    private void doGetPersonaje(String id_personaje) {
        Retrofit retrofit = RetrofitObject.getConnection();
        ApiConexiones api = retrofit.create(ApiConexiones.class);

        Call<PersonajeDisney> getUsuarios = api.getPersonaje(id_personaje);

        getUsuarios.enqueue(new Callback<PersonajeDisney>() {
            @Override
            public void onResponse(Call<PersonajeDisney> call, Response<PersonajeDisney> response) {
                if (response.isSuccessful()){
                    if (response.code() == HttpURLConnection.HTTP_OK){
                        if (response.body() != null){
                            PersonajeDisney p = response.body();
                            lblNombre.setText(p.getName());
                            lblInfo.setText(p.toString());
                            Picasso.get().load(p.getImageUrl())
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .error(R.drawable.ic_launcher_background)
                                    .into(imgPj);
                        }
                    }else {
                        Toast.makeText(PersonajeActivity.this, "Algo ha fallado." + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(PersonajeActivity.this, "No ha salido bien.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PersonajeDisney> call, Throwable t) {
                Toast.makeText(PersonajeActivity.this, "Error de conexión.", Toast.LENGTH_SHORT).show();
                Log.e("Failure", t.getMessage());
            }
        });
    }
}