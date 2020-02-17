package com.example.terapija;

public class Reminder {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    private String time;
    private int amount;
    private String end_date;

    Reminder(){
    }

    Reminder(String name, String time, int amount,String end_date){
        this.name=name;
        this.time=time;
        this.amount=amount;
        this.end_date=end_date;
    }
}
