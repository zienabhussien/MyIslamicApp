package com.example.myislamicapplication.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myislamicapplication.data.pojo.quran.Aya;

@Database(entities = {Aya.class},version = QuranDatabase.DATABASE_VERSION,exportSchema = false)
public abstract class QuranDatabase  extends RoomDatabase{
     public abstract QuranDao quranDao();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "quran.db";

    private static volatile QuranDatabase INSTANCE = null;

   public static QuranDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (QuranDatabase.class){
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuranDatabase.class, DATABASE_NAME)
                            .createFromAsset("quran/databases/quran.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
