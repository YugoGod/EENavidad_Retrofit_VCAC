package hugo.monton.blanco.eenavidad_retrofit.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import hugo.monton.blanco.eenavidad_retrofit.PersonajeActivity;
import hugo.monton.blanco.eenavidad_retrofit.R;
import hugo.monton.blanco.eenavidad_retrofit.modelos.PersonajeDisney;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.GeneralVH> {

    private Context context;
    private List<PersonajeDisney> objects;
    private int resource;

    public PersonajeAdapter(Context context, List<PersonajeDisney> objects, int resource) {
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public PersonajeAdapter.GeneralVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumView = LayoutInflater.from(context).inflate(resource, null);
        albumView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return new GeneralVH(albumView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeAdapter.GeneralVH holder, int position) {
        PersonajeDisney p = objects.get(position);

        holder.lblNombre.setText(p.getName());

        Picasso.get().load(p.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgPersonaje);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PersonajeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ID_PERSONAJE", String.valueOf(p.getId()));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class GeneralVH extends RecyclerView.ViewHolder {

        private ImageView imgPersonaje;
        private TextView lblNombre;

        public GeneralVH(@NonNull View itemView) {
            super(itemView);

            imgPersonaje = itemView.findViewById(R.id.imgPersonajesViewModel);
            lblNombre = itemView.findViewById(R.id.lblNombrePersonajeModel);
        }
    }
}
