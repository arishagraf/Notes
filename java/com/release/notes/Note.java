package com.release.notes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey (autoGenerate = true)
    private int id;  //all these fields will be added to table
    private String date;
    private String description;
    private int priority;

    public Note(String date, String description, int priority) {
        this.date = date;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {  //setter because id is not in constructor because it will be auto generated
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
