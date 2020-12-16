package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appusuariosupe.R;
import com.example.appusuariosupe.entidades.usuario;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListaUserAdapter extends RecyclerView.Adapter<ListaUserAdapter.UserViewHolder>{
    ArrayList<usuario> listaUsuario;
    public ListaUserAdapter(ArrayList<usuario> listaUsuario){
        this.listaUsuario=listaUsuario;
    }
    @Override
    public ListaUserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_usuario,null,false);
        return new UserViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {


        holder.documento.setText(listaUsuario.get(position).getDni().toString());
        holder.nombre.setText(listaUsuario.get(position).getNombre().toString());
        holder.profesion.setText(listaUsuario.get(position).getProfesion().toString());
        holder.correo.setText(listaUsuario.get(position).getEmail().toString());
        Picasso.get().load( listaUsuario.get(position).getUrl().toString()).resize(100,100).into(holder.profile);
//

    }

    @NonNull

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView profile;
        TextView documento,nombre,profesion,correo;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            documento= itemView.findViewById(R.id.twRDocumento);
            nombre= itemView.findViewById(R.id.twRNombre);
            profesion= itemView.findViewById(R.id.twProfesion);
            correo= itemView.findViewById(R.id.twCorreo);
            profile=itemView.findViewById(R.id.rimagemas);
        }
    }
}
