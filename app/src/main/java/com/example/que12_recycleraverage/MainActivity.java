package com.example.que12_recycleraverage;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements DataPass {
    RecyclerView recyclerView;
    Button button;


  String a,b,c;

  String[] array=new String[3];

  ArrayList<ModelData> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.button);

        arrayList.add(new ModelData("", "", "", ""));
        arrayList.add(new ModelData("", "", "", ""));
        arrayList.add(new ModelData("", "", "", ""));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        recyclerAdapter recyclerAdapter = new recyclerAdapter(arrayList, MainActivity.this,this);
        recyclerView.setAdapter(recyclerAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 hidekeyboard(view);
                array=recyclerAdapter.getlist();

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Messege")
                        .setPositiveButton("ok", null)
                        .setMessage("Average are :" + array[0] + "\n" +
                                "Average are :" + array[1]+ "\n" +
                                "Average are :" + array[2])
                        .show();
//


            }
        });


    }

    private void hidekeyboard(View view) {
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);
    }

    @Override
    public String pass(String x,String y,String z) {
        a=x;
        b=y;
        c=z;
        return null;
    }
}