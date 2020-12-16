package com.example.appusuariosupe.ui.listar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appusuariosupe.R;
import com.example.appusuariosupe.entidades.conexionSql;
import com.example.appusuariosupe.entidades.usuario;
import com.example.appusuariosupe.resource.utilidad;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.R.layout.simple_spinner_item;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListarFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ListarFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner cmbPersonas;
    ImageView img;
    TextView txtDni, txtNom, txtEmail,txtProfe,txturl;
    ArrayList<String> listaUsuarios;
    ArrayList<usuario> UsuariosList;
    conexionSql cnn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListarFragment newInstance(String param1, String param2) {
        ListarFragment fragment = new ListarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ListarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista= inflater.inflate(R.layout.fragment_listar,container,false);
        cmbPersonas=vista.findViewById(R.id.cmbOpcion);
        txtDni=vista.findViewById(R.id.txtDocumento);
        txtNom=vista.findViewById(R.id.txtNombre);
        txtProfe=vista.findViewById(R.id.txtProfesion);
        txtEmail=vista.findViewById(R.id.txtEmail);
        txturl=vista.findViewById(R.id.txturl);
        img=vista.findViewById(R.id.Limg);
        cnn= new conexionSql(getActivity(),"bd_usuarios",null,1);
        consultarUsuario();
        ArrayAdapter<CharSequence> adaptador= new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,
                listaUsuarios);
        cmbPersonas.setAdapter(adaptador);
        cmbPersonas.setOnItemSelectedListener(this);
        return vista;
        };

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long idl) {
        if (position !=0) {
            txtDni.setText(UsuariosList.get(position - 1).getDni().toString());
            txtNom.setText(UsuariosList.get(position - 1).getNombre().toString());
            txtProfe.setText(UsuariosList.get(position - 1).getProfesion().toString());
            txtEmail.setText(UsuariosList.get(position - 1).getEmail().toString());
            txturl.setText(UsuariosList.get(position - 1).getUrl().toString());
            Picasso.get().load(UsuariosList.get(position - 1).getUrl().toString()).into(img);
        }
        else{
            txtDni.setText("");
            txtNom.setText("");
            txtProfe.setText("");
            txturl.setText("");
    }


    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView){ }
    private void consultarUsuario(){
        SQLiteDatabase db= cnn.getReadableDatabase();
        usuario usuario=null;
        UsuariosList = new ArrayList<usuario>();
        Cursor cursor= db.rawQuery("SELECT * FROM " + utilidad.TABLA_USUARIO, null);
        while(cursor.moveToNext()){
            usuario= new usuario();
            usuario.setDni(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setProfesion(cursor.getString(2));
            usuario.setEmail(cursor.getString(3));
            usuario.setUrl(cursor.getString(4));
            Log.i("DNI",usuario.getDni().toString());
            Log.i("Nombre",usuario.getNombre().toString());
            Log.i("Profesion",usuario.getProfesion().toString());
            Log.i("Email",usuario.getEmail().toString());
            Log.i("Url",usuario.getUrl().toString());
            UsuariosList.add(usuario);
    }
        obtenerListaUsuarios();
    }
    private void obtenerListaUsuarios(){
        listaUsuarios= new ArrayList<String>();
        listaUsuarios.add("Seleccione");
        for ( int i=0;i<UsuariosList.size();i++ ){
            listaUsuarios.add(UsuariosList.get(i).getDni()+" - "+ UsuariosList.get(i).getNombre()+" - "+
                    UsuariosList.get(i).getProfesion() +"-" +UsuariosList.get(i).getEmail());

        }
}
}