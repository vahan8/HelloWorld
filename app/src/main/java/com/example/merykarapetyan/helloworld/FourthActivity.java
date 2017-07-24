package com.example.merykarapetyan.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FourthActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    String s1[],s2[];
    int imageResource[]={R.drawable.cat,R.drawable.dog,R.drawable.cat,R.drawable.dog,R.drawable.cat,R.drawable.dog,R.drawable.cat,R.drawable.dog};

    MyOwnAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        myRecyclerView=(RecyclerView)findViewById(R.id.myRecycler);
        s1=getResources().getStringArray(R.array.pet_name);
        s2=getResources().getStringArray(R.array.no);

        myAdapter=new MyOwnAdapter(this,s1,s2,imageResource);

       //attaching adapter to my recyclerView
        myRecyclerView.setAdapter(myAdapter);
        //what kind of layout manager you want to attach with RecyclerView:
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }





}
