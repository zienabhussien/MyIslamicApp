package com.example.myislamicapplication.data.pojo.prayermethod;

public class MOONSIGHTING implements IToMethod {
    public int id;
    public String name;
    public  Params params;


    @Override
    public PrayerTimingMethod toMethod() {
        return new PrayerTimingMethod(id,name,params,null);
    }

}
