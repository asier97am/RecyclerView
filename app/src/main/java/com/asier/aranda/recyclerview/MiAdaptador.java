package com.asier.aranda.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater; //


    //constructor. pasamos los datos
    MiAdaptador(Context context, List<String> data){
        this.mInflater=LayoutInflater.from(context);
        this.mData=data;
    }

    //infla cada fila del layout que hemos hecho oara cada fila
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }


    //recupera la posicion del array en el que estamos y
    //asigna en TExtView el nombre del animal
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        String animal= mData.get(position);
        holder.myTextView.setText(animal);
    }

    //total numero de filas
    @Override
    public int getItemCount(){
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{//clase ViewHolder
        TextView myTextView;
        ViewHolder(View itemView){//construcotor
            super(itemView);
            myTextView=itemView.findViewById(R.id.tvAnimalNombre);
        }
    }
}
