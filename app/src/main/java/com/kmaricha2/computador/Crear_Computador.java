package com.kmaricha2.computador;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Crear_Computador extends AppCompatActivity {
    private EditText txtRam;
    private Spinner spn_marca,spn_tipo;
    private Spinner spn_color;
    private Spinner spn_sistema;
    private String [] opc_color;
    private String [] opc_tipo;
    private String [] opc_marca;
    private String [] opc_sistema;
    private ArrayAdapter<String> adp_marca,adp_color,adp_tipo,adp_sistema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kmaricha2.computador.R.layout.activity_crear_computador);
        txtRam = findViewById(com.kmaricha2.computador.R.id.txtRam);
        //Spinner de Marcas
        spn_marca = findViewById(com.kmaricha2.computador.R.id.lst_marca);
        opc_marca = this.getResources().getStringArray(com.kmaricha2.computador.R.array.lst_sitema);
        adp_marca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_marca);
        spn_marca.setAdapter(adp_marca);
        //Spinner de Tipos
        spn_tipo = findViewById(com.kmaricha2.computador.R.id.lst_tipo);
        opc_tipo = this.getResources().getStringArray(com.kmaricha2.computador.R.array.lst_tipo);
        adp_tipo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_tipo);
        spn_tipo.setAdapter(adp_tipo);
        //Spinner de Colores
        spn_color = findViewById(com.kmaricha2.computador.R.id.lst_color);
        opc_color = this.getResources().getStringArray(com.kmaricha2.computador.R.array.lst_color);
        adp_color = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_color);
        spn_color.setAdapter(adp_color);
        //Spinner de Sistema
        spn_sistema = findViewById(com.kmaricha2.computador.R.id.lst_sistema);
        opc_sistema = this.getResources().getStringArray(com.kmaricha2.computador.R.array.lst_sitema);
        adp_sistema = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_sistema);
        spn_sistema.setAdapter(adp_sistema);


    }
    public String obtenerCampo(Spinner spinner){
        String cadena="";
        cadena=spinner.getSelectedItem().toString();
        //Toast.makeText(this,cadena,Toast.LENGTH_LONG).show();
        return  cadena;
    }

    public void Numerofoto(){
        ArrayList<Object> foto = new ArrayList<>();
        foto.add(com.kmaricha2.computador.R.drawable.hp);
        foto.add(com.kmaricha2.computador.R.drawable.compaq);
        foto.add(com.kmaricha2.computador.R.drawable.dell);
    }


    public int Numerofoto(Spinner spinner){
        int foto=0;
        int posicion=spinner.getSelectedItemPosition();
        if (posicion==0){
            foto= com.kmaricha2.computador.R.drawable.hp;
        }
        if (posicion==1){
            foto= com.kmaricha2.computador.R.drawable.compaq;
        }
        if (posicion==2){
            foto= com.kmaricha2.computador.R.drawable.dell;
        }
        if (posicion==3){
            foto= com.kmaricha2.computador.R.drawable.lenovo;
        }
        return foto;
    }

    public void guardar(View view){


        String ram,id;
        String marca,color,tipo,sistema;
        int foto;
        ram=txtRam.getText().toString();
        marca=obtenerCampo(spn_marca);
        tipo=obtenerCampo(spn_tipo);
        color=obtenerCampo(spn_color);
        sistema=obtenerCampo(spn_sistema);
        id= Datos_computador.getId();
        foto=Numerofoto(spn_marca);

        Computador c=new Computador(id,marca,ram,color,tipo,sistema,foto);
        c.guardar();
        Snackbar.make(view, getResources().getString(com.kmaricha2.computador.R.string.guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        limpiar();
    }
    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtRam.setText("");
        spn_marca.setSelection(0);
        spn_tipo.setSelection(0);
        spn_color.setSelection(0);
        spn_sistema.setSelection(0);


    }
    public void Limpiar(View v){
        limpiar();
    }


    public void onBackPressed(){
        finish();
        Intent i = new Intent(Crear_Computador.this,Principal.class);
        startActivity(i);
    }


}
