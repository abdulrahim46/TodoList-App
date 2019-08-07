package com.example.himanshu.todosampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Second_Activity extends AppCompatActivity {


    Button save;
    ArrayList<String> addArray = new ArrayList<String>();
    EditText txt;
    ListView show;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        txt = (EditText)findViewById(R.id.todoText);
        show = (ListView) findViewById(R.id.myListView);
        save = (Button)findViewById(R.id.SaveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if (addArray.contains(getInput)){
                    Toast.makeText(getBaseContext(), "Todo added to Todo List", Toast.LENGTH_LONG).show();
                }
                else if (getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "Input field is empty!", Toast.LENGTH_LONG).show();

                }
                else{
                    addArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Second_Activity.this, android.R.layout.simple_list_item_1, addArray);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.todoText)).setText(" ");
                }

            }
        });



    }
}
