package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button AddButton;
    Button ClearButton;
    EditText Task;
    ListView TasksToDo;
    ArrayAdapter TaskManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddButton=findViewById(R.id.button);
        ClearButton=findViewById(R.id.button2);
        Task=findViewById(R.id.editText);
        TasksToDo=findViewById(R.id.TaskList);
        ArrayList<String> TaskLog=new ArrayList<String>();
       TaskManager=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,TaskLog);
        TasksToDo.setAdapter(TaskManager);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Task!=null){
                    String newtask=Task.getText().toString();
                    TaskLog.add(newtask);
                    TaskManager.notifyDataSetChanged();
                    Task.setText("");
                }
            }
        });
        ClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskLog.clear();
                TaskManager.notifyDataSetChanged();
                Task.setText("");
            }
        });
    }
}