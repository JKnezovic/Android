package com.example.terapija;

public class Therapy {
    private String name;
    private String type;
    private int dialy;
    private String date;
    private int amount;
    private String time;
    private int weekly;

    public Therapy(){

    }


    public Therapy(String name,String type,int dialy,String date,int amount,String time,int weekly){
        this.name=name;
        this.type=type;
        this.dialy=dialy;
        this.date=date;
        this.amount=amount;
        this.time=time;
        this.weekly=weekly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDialy() {
        return dialy;
    }

    public void setDialy(int daily) {
        this.dialy = daily;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWeekly() {
        return weekly;
    }

    public void setWeekly(int weekly) {
        this.weekly = weekly;
    }


}
