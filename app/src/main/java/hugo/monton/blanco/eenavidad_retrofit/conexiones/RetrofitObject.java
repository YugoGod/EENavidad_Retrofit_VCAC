package hugo.monton.blanco.eenavidad_retrofit.conexiones;

import hugo.monton.blanco.eenavidad_retrofit.configuraciones.Constantes;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    public static Retrofit getConnection() {
        return new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL) // Atributo 'BASE_URL' de la clase 'Constantes'.
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
