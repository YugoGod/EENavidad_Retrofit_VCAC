package hugo.monton.blanco.eenavidad_retrofit.conexiones;

import hugo.monton.blanco.eenavidad_retrofit.modelos.GeneralDisney;
import hugo.monton.blanco.eenavidad_retrofit.modelos.PersonajeDisney;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiConexiones {

    @GET("/characters/")
    Call<GeneralDisney> getPersonajes();

    @GET("/characters/{idPersonaje}")
    Call<PersonajeDisney> getPersonaje(@Path("idPersonaje") String id);

}
