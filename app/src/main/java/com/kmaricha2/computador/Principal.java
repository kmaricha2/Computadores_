package com.kmaricha2.computador;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements AdaptadorComputador.OnComputadorClickListener{
    private RecyclerView ListaComputador;
    private ArrayList<Computador> Computador;
    private Resources res;
    private static String db = "computador";
    private DatabaseReference databaseReference;
    private Intent i;
    private LinearLayoutManager llm;
    private AdaptadorComputador adapter;
    private ArrayList<Computador> computador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kmaricha2.computador.R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(com.kmaricha2.computador.R.id.toolbar);
        setSupportActionBar(toolbar);
        ListaComputador=findViewById(com.kmaricha2.computador.R.id.listaComputadores);
        computador = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorComputador(computador,this);

        ListaComputador.setLayoutManager(llm);
        ListaComputador.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                computador.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Computador c = snapshot.getValue(Computador.class);
                        computador.add(c);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos_computador.setCarros(computador);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void crearComputardo(View v){
        i = new Intent(Principal.this,Crear_Computador.class);
        startActivity(i);


    }

    @Override
    public void onComputadorClick(Computador c) {

    }
}
