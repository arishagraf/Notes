package com.release.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class AddNote extends AppCompatActivity {
    public static final String EXTRA_ID = "com.release.notes.EXTRA_ID";
    public static final String EXTRA_DESCRIPTION = "com.release.notes.EXTRA_DESCRIPTION";
    public static final String EXTRA_DATE = "com.release.notes.EXTRA_DATE";
    public static final String EXTRA_PRIORITY = "com.release.notes.EXTRA_PRIORITY";

    private EditText et_text;
    private TextView tv_date;
    private Button btn_save;
    private TextView numberPicker, numberPicker2, numberPicker3, numberPicker4,
            numberPicker5, numberPicker6, numberPicker7, numberPicker8,
            numberPicker9, numberPicker10, numberPicker11, numberPicker12;
    int myColor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);

        et_text = findViewById(R.id.et_text);
        tv_date = findViewById(R.id.tv_date);
        numberPicker = findViewById(R.id.number_picker_priority);
        numberPicker2 = findViewById(R.id.number_picker_priority2);
        numberPicker3 = findViewById(R.id.number_picker_priority3);
        numberPicker4 = findViewById(R.id.number_picker_priority4);
        numberPicker5 = findViewById(R.id.number_picker_priority5);
        numberPicker6 = findViewById(R.id.number_picker_priority6);
        numberPicker7 = findViewById(R.id.number_picker_priority7);
        numberPicker8 = findViewById(R.id.number_picker_priority8);
        numberPicker9 = findViewById(R.id.number_picker_priority9);
        numberPicker10 = findViewById(R.id.number_picker_priority10);
        numberPicker11 = findViewById(R.id.number_picker_priority11);
        numberPicker12 = findViewById(R.id.number_picker_priority12);




        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_ID)){
            getSupportActionBar().setTitle("Edit Note");
            et_text.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            tv_date.setText(intent.getStringExtra(EXTRA_DATE));
            numberPicker.setText(intent.getStringExtra(EXTRA_PRIORITY));
        }
        else {
            getSupportActionBar().setTitle("Add Note");
        }



        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        tv_date.setText(currentDate);

        btn_save = findViewById(R.id.btn_save);


        numberPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myColor = Color.parseColor("#ffd9b3");//0xFFFE840E; #ffd9b3
            }
        });
        numberPicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#ffccff");
            }
        });
        numberPicker3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#ccccff");
            }
        });
        numberPicker4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#ffb3bc");
            }
        });
        numberPicker5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#ffffcc");
            }
        });
        numberPicker6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#ccffcc");
            }
        });
        numberPicker7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#ccffff");
            }
        });
        numberPicker8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#e09ff9");
            }
        });
        numberPicker9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#e6ccb3");
            }
        });
        numberPicker10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#d9d9d9");
            }
        });
        numberPicker11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#88c851");
            }
        });
        numberPicker12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myColor = Color.parseColor("#ff3c1a");
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }

            private void saveNote() {
                String date = tv_date.getText().toString();
                String descriprion = et_text.getText().toString();
                if(myColor != 0){
                    int priority = Integer.parseInt(String.valueOf(myColor));

                    Intent data = new Intent();
                    data.putExtra(EXTRA_DESCRIPTION, descriprion);
                    data.putExtra(EXTRA_DATE, date);
                    data.putExtra(EXTRA_PRIORITY, priority);

                    int id = getIntent().getIntExtra(EXTRA_ID, -1);
                    if(id !=-1){
                        data.putExtra(EXTRA_ID, id);
                    }

                    setResult(RESULT_OK, data);
                    finish();
                } else if(myColor == 0){
                    myColor = Color.parseColor("#ffffff");
                    int priority = Integer.parseInt(String.valueOf(myColor));

                    Intent data = new Intent();
                    data.putExtra(EXTRA_DESCRIPTION, descriprion);
                    data.putExtra(EXTRA_DATE, date);
                    data.putExtra(EXTRA_PRIORITY, priority);

                    int id = getIntent().getIntExtra(EXTRA_ID, -1);
                    if(id !=-1){
                        data.putExtra(EXTRA_ID, id);
                    }

                    setResult(RESULT_OK, data);
                    finish();
                }


                if(descriprion.trim().isEmpty()){
                    Toast.makeText(AddNote.this, "You can't save empty note", Toast.LENGTH_LONG).show();
                    return;
                }
/*
                Intent data = new Intent();
                data.putExtra(EXTRA_DESCRIPTION, descriprion);
                data.putExtra(EXTRA_DATE, date);
                data.putExtra(EXTRA_PRIORITY, priority);

                int id = getIntent().getIntExtra(EXTRA_ID, -1);
                if(id !=-1){
                    data.putExtra(EXTRA_ID, id);
                }

                setResult(RESULT_OK, data);
                finish(); */

            }
        });

    }
}
