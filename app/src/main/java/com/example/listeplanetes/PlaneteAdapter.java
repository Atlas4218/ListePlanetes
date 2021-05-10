package com.example.listeplanetes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

public class PlaneteAdapter extends BaseAdapter {

    Data donnees;
    MainActivity main;
    int nbChecked=0;


    @Override
    public int getCount() {

        return donnees.getNoms().size();
    }

    @Override
    public Object getItem(int i) {
        return donnees.getNoms().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) main.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.choixTaille);

        nomPlanete.setText(donnees.getNoms().get(i));


        //  installer l'adaptateur pour la liste déroulante (spinner)
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(main, android.R.layout.simple_spinner_item, donnees.getTailles());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                spinner.setEnabled(!checkBox.isChecked());
                if(checkBox.isChecked()){

                    nbChecked++;
                } else{
                    nbChecked--;
                }
                Button btn = main.confirmButton;
                if (nbChecked==donnees.getNoms().size())
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            }
        });



        return itemView;
    }
    public void setMain(MainActivity main){
        this.main=main;
    }

    public void verification() {

    }

    public void setData(Data donnees) {
        this.donnees = donnees;
    }
}
