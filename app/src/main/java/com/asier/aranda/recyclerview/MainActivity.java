package com.asier.aranda.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MiAdaptadorSimple adapter;
    private EditText View;
    private EditText view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> animalNames=new ArrayList<>();
        animalNames.add("Caballo");
        animalNames.add("Vaca");
        animalNames.add("Perro");
        animalNames.add("Gato");
        animalNames.add("León");
        animalNames.add("Tigre");
        animalNames.add("Rinoceronte");
        animalNames.add("Elefante");
        animalNames.add("Águila");
        animalNames.add("Mariposa");
        animalNames.add("Serpiente");
        animalNames.add("Oso");
        animalNames.add("Avestruz");






        RecyclerView recyclerView= findViewById(R.id.recyclerViewAnimales);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);

        //aqui referencio con el otro java
        adapter=new MiAdaptadorSimple(this,animalNames);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        EditText tvAnimalAnadido=findViewById(R.id.editTextTextPersonName);
        Button bAnadir= findViewById(R.id.añadir);
        bAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String item =tvAnimalAnadido.getText().toString();
                int posicionInsercion=(adapter.getPos()>0)? adapter.getPos()+1:0;
                animalNames.add(posicionInsercion,item);
                adapter.notifyItemInserted(posicionInsercion);
                adapter.notifyItemRangeChanged(0,animalNames.size());
                recyclerView.scheduleLayoutAnimation();
            }
        });

        Button bBorrar= findViewById(R.id.borrar);
        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                int posicion=adapter.getPos();
                if(adapter.getPos()>=0){
                    animalNames.remove(adapter.getPos());
                    adapter.notifyItemRemoved(adapter.getPos());
                    adapter.notifyItemRangeChanged(0,animalNames.size());
                    adapter.decrementarPos();
                    recyclerView.scheduleLayoutAnimation();
                }
            }
        });
    }
}