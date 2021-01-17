package com.release.notes;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;
    public abstract NotesDao notesDao();
    public static synchronized NoteDatabase getInstance(Context context){
        if(instance ==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            new PopulateDbAsyncTask(instance).execute();
            super.onCreate(db);
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private NotesDao notesDao;
        private PopulateDbAsyncTask(NoteDatabase db){
            notesDao = db.notesDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
    //        notesDao.insert(new Note("28.02.2020", "Text is here", 10));
      //      notesDao.insert(new Note("14.03.2020", "Hello, how are you?", 2));
        //    notesDao.insert(new Note("01.01.2021", "Mir geh't Scheisse und dir?", 4));
            return null;
        }
    }
}
