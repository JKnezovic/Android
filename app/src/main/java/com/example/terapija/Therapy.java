package com.example.terapija;

public class Therapy {
    private String name;
    private String type;

    public Therapy(String name,String type){
        this.name=name;
        this.type=type;

    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }


}
