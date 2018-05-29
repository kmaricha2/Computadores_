package com.kmaricha2.computador;

import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class AdaptadorComputador extends RecyclerView.Adapter<AdaptadorComputador.ComputadorViewHolder>{
    private ArrayList<Computador> computador;
    private Resources res;
    private OnComputadorClickListener clickListener;
    public AdaptadorComputador(ArrayList<Computador> computadores, OnComputadorClickListener clickListener) {
        this.computador = computadores;
        this.clickListener = clickListener;
    }

    @Override

        public AdaptadorComputador.ComputadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).
                inflate(com.kmaricha2.computador.R.layout.item_computador, parent, false);
        return new ComputadorViewHolder(v);
    }

    @Override

        public void onBindViewHolder(AdaptadorComputador.ComputadorViewHolder holder, int position){
        final Computador c = computador.get(position);
        holder.foto.setImageDrawable(ResourcesCompat.getDrawable(res,c.getFoto(),null));
        holder.marca.setText(c.getMarca());
        holder.ram.setText(c.getRam());
        holder.color.setText(c.getColor());
        holder.sistema.setText(c.getSistema());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { clickListener.onComputadorClick(c);
            }
        });



    }
    @Override
    public int getItemCount() { return computador.size(); }

    public static class ComputadorViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView marca;
        private TextView ram;
        private TextView color;
        private TextView sistema;
        private View v;

        public ComputadorViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(com.kmaricha2.computador.R.id.imgFoto);
            marca = v.findViewById(com.kmaricha2.computador.R.id.lblMarca);
            ram = v.findViewById(com.kmaricha2.computador.R.id.lblRam);
            color = v.findViewById(com.kmaricha2.computador.R.id.lblColors);
            sistema= v.findViewById(com.kmaricha2.computador.R.id.lblsistems);

        }

    }
    public interface OnComputadorClickListener{
        void onComputadorClick(Computador c);
    }

}
