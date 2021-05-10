package com.example.listeplanetes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    Button confirmButton;
    PlaneteAdapter adapter;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        confirmButton= (Button) findViewById(R.id.confirm_button);
        listview = (ListView) findViewById(R.id.listView);

        Data donnees = new Data();
        adapter = new PlaneteAdapter();
        adapter.setMain(MainActivity.this);
        adapter.setData(donnees);
        listview.setAdapter(adapter);

        confirmButton.setEnabled(false);

        confirmButton.setOnClickListener((view) -> {
            int score = 0;

            String[] taillesPlanettes = donnees.getTailles();

            for(int i=0; i<taillesPlanettes.length;i++){
                View vw = listview.getChildAt(i);
                spinner = vw.findViewById(R.id.choixTaille);
                String tailleSelect = spinner.getSelectedItem().toString();
                if(tailleSelect.equals(taillesPlanettes[i]))
                    score++;
                }
            Toast.makeText(MainActivity.this, "Score: "+score+"/"+taillesPlanettes.length,Toast.LENGTH_LONG).show();
        });

    }

}