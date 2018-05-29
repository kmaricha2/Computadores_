package com.kmaricha2.computador;

public class  Modificar_computador {
    private  EditText txtcolor;
    private  EditText txtsistema,txtram;
    private  TextInputLayout icajaColor;
    private TextInputLayout icajaSistema;
    private TextInputLayout icajaram;
    ArrayList<Integer> foto;
    private Resources res;
    private Spinner computadores_spiner;
    private String ram,sistema,color,ramexis;
    private int marca_d,fot;
    private String computadores_vector[];
    private Bundle bundle;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_Computador);
        txtcolor = (EditText)findViewById(R.id.txtcolor_modi);
        txtram = (EditText)findViewById(R.id.txtram_modi);
        txtsistema = (EditText)findViewById(R.id.txtsistema_modi);
        computadores_spiner=(Spinner) findViewById(R.id.cbxmarca_modi);
        res = this.getResources();
        computadores_vector=res.getStringArray(R.array.marca);
        i = getIntent();
        bundle = i.getBundleExtra("datos");
        ram = bundle.getString("ram");
        color = bundle.getString("color");
        sistema = bundle.getString("sistema");
        txtsistema.setText(sistema);
        txtram.setText(ram);

        txtcolor.setText(color);
        marca_d = bundle.getInt("marca");
        fot = bundle.getInt("foto");
        ArrayAdapter<String> adapter_computadores = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,computadores_vector);
        computadores_spiner.setAdapter(adapter_computadores);
        computadores_spiner.setSelection(marca_d);
        icajaColor = (TextInputLayout)findViewById(R.id.cajacolor);
        icajaSistema = (TextInputLayout)findViewById(R.id.cajasistema);
        icajaram = (TextInputLayout)findViewById(R.id.cajaram);
    }

    public void Modificar(View v){
        String nom = txtcolor.getText().toString();
        String ape = txtsistema.getText().toString();
        String ced = txtram.getText().toString();
        int mod =Datos.Modificar(nom,ape,ram,ced,computadores_spiner.getSelectedItemPosition());
        Snackbar.make(v, ""+mod, Snackbar.LENGTH_LONG).setAction("action", null).show();
        if (mod==1){
            Snackbar.make(v, res.getString(R.string.mensaje_exito_modificar), Snackbar.LENGTH_LONG).setAction("action", null).show();
            Cancelar();
        } else if(mod==2) {
            Snackbar.make(v, res.getString(R.string.error_modificar), Snackbar.LENGTH_LONG).setAction("action", null).show();
        }else {
            Snackbar.make(v, res.getString(R.string.existe_Computador), Snackbar.LENGTH_LONG).setAction("action", null).show();
        }
    }
    public void Cancelar(View v){
        Cancelar();
    }
    public void Cancelar(){
        String nom = txtcolor.getText().toString();
        String ape = txtsistema.getText().toString();
        String ced = txtram.getText().toString();
        Intent i = new Intent(modificar_Computador.this,Detalle_Computador.class);
        Bundle b = new Bundle();
        b.putString("ram",ced);
        b.putString("color",nom);
        b.putString("sistema",ape);

        b.putInt("marca",computadores_spiner.getSelectedItemPosition());
        b.putInt("fotos",fot);
        i.putExtra("datos",b);
        startActivity(i);
    }
}

}
