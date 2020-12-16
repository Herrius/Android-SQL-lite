package com.example.appusuariosupe.ui.consult;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appusuariosupe.R;
import com.example.appusuariosupe.entidades.conexionSql;
import com.example.appusuariosupe.resource.utilidad;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultFragment extends Fragment implements View.OnClickListener {
    Button btnBuscar;
    EditText edtDNI;
    TextView mdni,mnombre,mprofesion,memail,murl;
    ImageView img;
    conexionSql cnn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultFragment newInstance(String param1, String param2) {
        ConsultFragment fragment = new ConsultFragment();
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

        View vista= inflater.inflate(R.layout.fragment_consult, container, false);
        edtDNI=vista.findViewById(R.id.dni);
        mdni=vista.findViewById(R.id.mDni);
        mnombre=vista.findViewById(R.id.mNombre);
        mprofesion=vista.findViewById(R.id.mProfesion);
        memail=vista.findViewById(R.id.mEmail);
        murl=vista.findViewById(R.id.mUrl);
        img=vista.findViewById(R.id.img);
        btnBuscar=vista.findViewById(R.id.buscar);
        btnBuscar.setOnClickListener(this);
        cnn=new conexionSql(getActivity(),"bd_usuarios",null,1);
        return vista;
    }
    @Override
    public void onClick(View view) {
        consultUsuario();
    }
    private void consultUsuario(){
        SQLiteDatabase db=cnn.getReadableDatabase();
        String[] parametros={edtDNI.getText().toString()};
        String[] campos={utilidad.CAMPO_DNI,utilidad.CAMPO_NOMBRE,utilidad.CAMPO_PROFESION,utilidad.CAMPO_EMAIL,utilidad.CAMPO_URL};
        try {
            Cursor cursor = db.query(utilidad.TABLA_USUARIO,campos, utilidad.CAMPO_DNI+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            mdni.setText(cursor.getString(0));
            mnombre.setText(cursor.getString(1));
            mprofesion.setText(cursor.getString(2));
            memail.setText(cursor.getString(3));
            murl.setText(cursor.getString(4));
            Picasso.get().load(cursor.getString(4)).into(img);
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(getActivity(), "El registro no existe", Toast.LENGTH_SHORT).show();
        }
    }


}