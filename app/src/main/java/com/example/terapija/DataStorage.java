package com.example.terapija;

import java.util.HashMap;

public class DataStorage {


    public static HashMap<Integer, Therapy> listViewData = new HashMap<Integer, Therapy>();
    public static void fillData() {
        for(int i = 0; i < names.length; i++){
            final boolean available = (i%3 == 0);
            Therapy aTherapy = new Therapy(names[i], descriptions[i]);
            listViewData.put(i, aTherapy);
        }
    }


    private static String[] names = {"Klavocin", "Aspirin", "Lupocet"};

    private static String[] descriptions = {"Prasak", "Tableta", "Pill"};


}
