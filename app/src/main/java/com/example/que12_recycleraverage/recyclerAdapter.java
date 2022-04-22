package com.example.que12_recycleraverage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.holder> {
    ArrayList<ModelData> arrayList;
    Context context;
    Float a,b,c;

     DataPass dataPass;

     String xx,yy,zz;


      String[] adpData=new String[3];


    public recyclerAdapter(ArrayList<ModelData> arrayList, Context context,DataPass dataPass){
        this.arrayList = arrayList;
        this.context = context;
        this.dataPass=dataPass;

    }

    @NonNull
    @Override
    public recyclerAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {

    holder.editText1.setText(arrayList.get(position).getEdittext1());
    holder.editText2.setText(arrayList.get(position).getEdittext2());
    holder.editText3.setText(arrayList.get(position).getEdittext2());

        holder.editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(holder.editText1.getText().toString().isEmpty() || holder.editText2.getText().toString().isEmpty())
                {

                }
                else
                {
                    a= Float.parseFloat(holder.editText1.getText().toString());
                    b= Float.parseFloat(holder.editText2.getText().toString());
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(holder.editText3.getText().toString().isEmpty())
                {
                }
                else
                {
                    c = Float.parseFloat(holder.editText3.getText().toString());
                    holder.average.setText(String.valueOf((a+b+c)/3));
                    adpData[position]=String.valueOf((a+b+c)/3);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        EditText editText1, editText2, editText3;
        TextView average;

        public holder(@NonNull View itemView) {
            super(itemView);
            editText1 = itemView.findViewById(R.id.edittext1);
            editText2 = itemView.findViewById(R.id.edittext2);
            editText3 = itemView.findViewById(R.id.edittext3);
            average = itemView.findViewById(R.id.average);


        }
    }
    public String[] getlist()  //method for function return
    {
        return adpData; //Array return
    }
}