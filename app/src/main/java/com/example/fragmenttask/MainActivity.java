package com.example.fragmenttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button currentButton, compliteButton;

    FragmentManager fm;
    FragmentTransaction ft;
    CurrentTaskFragment ctf;
    CompliteTaskFragment comtf;
    ArrayList<String> tasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentButton = findViewById(R.id.current_task_btn);
        compliteButton = findViewById(R.id.complite_task_btn);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ctf = new CurrentTaskFragment(tasks);
        comtf = new CompliteTaskFragment(tasks);
        ft.add(R.id.container_task, ctf);
        ft.commit();
        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft = fm.beginTransaction();
                ft.replace(R.id.container_task, ctf);
                ft.commit();
            }
        });
        compliteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft = fm.beginTransaction();
                ft.replace(R.id.container_task, comtf);
                ft.commit();
            }
        });
    }
}