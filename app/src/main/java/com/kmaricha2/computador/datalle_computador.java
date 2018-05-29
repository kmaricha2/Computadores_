package com.kmaricha2.computador;

public class datalle_computador {
    import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

    public class Detalle_persona extends AppCompatActivity {
        private CollapsingToolbarLayout collapsingToolbarLayout;
        private Persona p;
        private String marca,sistema,sistema;
        private int marca;
        private Bundle bundle;
        private TextView nom,ced,apel,se;
        private Intent i;
        private int fot;
        private ImageView foto;
        private Resources res;
        String computadores_vector[];
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detalle_persona);
            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
            setSupportActionBar(toolbar);
            //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            res = this.getResources();
            computadores_vector=res.getStringArray(R.array.marca);
            collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbard);
            foto = (ImageView) findViewById(R.id.fotopersona);
            nom = (TextView) findViewById(R.id.txt_tbl_sistema);
            ced = (TextView) findViewById(R.id.txt_tbl_marca);
            apel = (TextView) findViewById(R.id.txt_tbl_sistema);
            se = (TextView) findViewById(R.id.txt_tbl_marca);
            i = getIntent();
            bundle = i.getBundleExtra("datos");
            marca = bundle.getString("marca");
            sistema = bundle.getString("sistema");
            sistema = bundle.getString("sistema");
            marca = bundle.getInt("marca");
            fot = bundle.getInt("foto");
            nom.setText(sistema);
            ced.setText(marca);
            apel.setText(sistema);
            se.setText(computadores_vector[marca]);

            foto.setImageDrawable(ResourcesCompat.getDrawable(res,fot,null));
            collapsingToolbarLayout.setTitle(sistema+" "+sistema);
        }

        public void Eliminar(View v){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(res.getString(R.string.titulo_eliminar_persona));
            builder.setMessage(res.getString(R.string.eliminar_mensaje));
            String positivo= res.getString(R.string.si_eliminar);
            String negativo =res.getString(R.string.no_eliminar);

            builder.setPositiveButton(positivo,new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface,int i){
                    Persona p = new Persona(marca);
                    Datos.EliminarPersona(p);

                    onBackPressed();

                }
            });


            builder.setNegativeButton(negativo,new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface,int i){
                }
            });



            AlertDialog dialog = builder.create();
            dialog.show();;
        }

        public void onBackPressed(){
            finish();
            Intent i = new Intent(Detalle_persona.this,Principal.class);
            startActivity(i);
        }

        public void ModificarPersona(View v) {
            Intent i = new Intent(Detalle_persona.this,modificar_persona.class);
            i.putExtra("datos",bundle);
            startActivity(i);

        }
    }

}
