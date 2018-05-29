package com.kmaricha2.computador;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by kmaricha on 29/05/2018.
 */

class Datos_computador {
    private static ArrayList<Computador>  computador = new ArrayList();
    private static String db = "computador";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public static void guardar(Computador c){
        databaseReference.child(db).child(c.getId()).setValue(c);

    }

    public static ArrayList<Computador>obtener(){
        return computador;
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setCarros(ArrayList<Computador> carros){
        Datos_computador.computador= carros;

    }
}
