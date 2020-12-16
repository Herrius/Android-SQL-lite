package com.example.appusuariosupe.ui.activity.listaFull;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appusuariosupe.R;
import com.example.appusuariosupe.entidades.conexionSql;
import com.example.appusuariosupe.entidades.usuario;
import com.example.appusuariosupe.resource.utilidad;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Adaptadores.ListaUserAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaCompleta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaCompleta extends Fragment {
    ArrayList<usuario> listUsuario;
    RecyclerView recyclerViewUsuarios;
    conexionSql cnn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaCompleta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaCompleta.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaCompleta newInstance(String param1, String param2) {
        ListaCompleta fragment = new ListaCompleta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            
        View vista= inflater.inflate(R.layout.fragment_lista_completa,container,false);
        cnn= new conexionSql(getActivity(),"bd_usuarios",null,1);
        listUsuario=new ArrayList<>();
        recyclerViewUsuarios=vista.findViewById(R.id.recyclerUsuarios);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(getActivity()));

        consultarListaUsuarios();
        ListaUserAdapter adapter=new ListaUserAdapter(listUsuario);
        recyclerViewUsuarios.setAdapter(adapter);

        return vista;
    }



    private void consultarListaUsuarios() {
        SQLiteDatabase db=cnn.getReadableDatabase();
        usuario usuario=null; // para llenar la inf
        Cursor cursor=db.rawQuery("Select * from "+ utilidad.TABLA_USUARIO,null);
        while (cursor.moveToNext()){
            usuario=new usuario();
            usuario.setDni(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setProfesion(cursor.getString(2));
            usuario.setEmail(cursor.getString(3));
            usuario.setUrl(cursor.getString(4));

            listUsuario.add(usuario);
        }


    }



}