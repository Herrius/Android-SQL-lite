package com.example.appusuariosupe.ui.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appusuariosupe.R;


import java.lang.reflect.Array;

/**
 * A fragment representing a list of Items.
 */
public class ActividadesFragment extends Fragment {
    EditText inicio,fin,descripcio;
    Button btnguardar;
    Spinner actividad;
    String reserva;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ActividadesFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ActividadesFragment newInstance(int columnCount) {
        ActividadesFragment fragment = new ActividadesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View vista=inflater.inflate(R.layout.fragment_actividades_list, container, false);
        inicio=vista.findViewById(R.id.txtInicio);
        fin=vista.findViewById(R.id.txtFin);
        descripcio=vista.findViewById(R.id.txtdescripcion);
        btnguardar=vista.findViewById(R.id.btnGuardar);
        actividad=vista.findViewById(R.id.opciones);



        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"La actividad tipo "+actividad.getSelectedItem().toString()  +" inicia "+ inicio.getText().toString()+" y acaba a las "+fin.getText().toString()
                        + "y consiste en: "+descripcio.getText().toString()
                        ,Toast.LENGTH_LONG).show();
            }
        });
        return vista;
    }
}