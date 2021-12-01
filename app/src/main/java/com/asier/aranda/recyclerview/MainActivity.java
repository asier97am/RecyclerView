package com.asier.aranda.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MiAdaptador adapter;

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
        adapter=new MiAdaptador(this,animalNames);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}