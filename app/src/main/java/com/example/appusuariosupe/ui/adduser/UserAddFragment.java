package com.example.appusuariosupe.ui.adduser;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appusuariosupe.R;
import com.example.appusuariosupe.entidades.conexionSql;
import com.example.appusuariosupe.resource.utilidad;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserAddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserAddFragment extends Fragment implements View.OnClickListener {
    EditText txtdco,txtnombre,txtprofe,txtcorreo,txturl;
    Button btnguardar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserAddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserAddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserAddFragment newInstance(String param1, String param2) {
        UserAddFragment fragment = new UserAddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_user_add, container, false);
        txtdco=vista.findViewById(R.id.txtDocumento);
        txtnombre=vista.findViewById(R.id.txtNombre);
        txtprofe=vista.findViewById(R.id.txtProfesion);
        txtcorreo=vista.findViewById(R.id.txtEmail);
        txturl=vista.findViewById(R.id.txturl);
        btnguardar=vista.findViewById(R.id.btnGuardar);
        btnguardar.setOnClickListener(this);
        return vista;
    }

    private void registrarUsuario() {
        conexionSql conn= new conexionSql(getActivity(),"bd_usuarios",null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidad.CAMPO_DNI,txtdco.getText().toString());
        values.put(utilidad.CAMPO_NOMBRE,txtnombre.getText().toString());
        values.put(utilidad.CAMPO_PROFESION,txtprofe.getText().toString());
        values.put(utilidad.CAMPO_EMAIL,txtcorreo.getText().toString());
        values.put(utilidad.CAMPO_URL,txturl.getText().toString());
        Long idresultado=db.insert(utilidad.TABLA_USUARIO,utilidad.CAMPO_DNI,values);
        Toast.makeText(getContext(),"Guardar datos de:"+ txtdco.getText().toString()+" "+txtnombre.getText().toString(),Toast.LENGTH_SHORT).show();
        db.close();
    }

    @Override
    public void onClick(View view) {
        registrarUsuario();
    }
}