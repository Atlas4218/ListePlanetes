package com.example.listeplanetes;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    ArrayList<String> noms;
    String[] tailles;
    public Data(){
        noms = new ArrayList<>();
        String[] listNoms = {"Mercure", "Venus", "Terre", "Mars", "Jupiter", "Saturne", "Neptune", "Pluton"};
        noms.addAll(Arrays.asList(listNoms));


        tailles = new String[]{"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
    }

    public String[] getTailles() {
        return tailles;
    }

    public String getTaille(int i){
        return tailles[i];
    }
    public void setTailles(String[] tailles) {
        this.tailles = tailles;
    }

    public ArrayList<String> getNoms() {
        return noms;
    }

    public String getNom(int i){
        return noms.get(i);
    }

    public void setNoms(ArrayList<String> noms) {
        this.noms = noms;
    }
}
