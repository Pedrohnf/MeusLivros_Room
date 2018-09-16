package com.example.phnf2014.meuslivros_room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Livro.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LivroDao livroDao();

    private static AppDatabase INSTANCE;

    static AppDatabase getDatabase(final Context context){

        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,"livro_database.sqlite")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
