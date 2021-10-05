package com.example.myislamicapplication.data.pojo.prayermethod;
public class GULF implements IToMethod {
    public int id;
    public String name;
    public  Params params;
    public Location location;

    @Override
    public PrayerTimingMethod toMethod() {
        return new PrayerTimingMethod(id,name,params,location);
    }
}
