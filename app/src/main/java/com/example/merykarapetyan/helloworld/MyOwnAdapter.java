package com.example.merykarapetyan.helloworld;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mery.karapetyan on 20/07/17.
 */

public class MyOwnAdapter extends RecyclerView.Adapter <MyOwnAdapter.MyOwnHolder>{

    String data1[],data2[];
    int img[];
    Context ctx;

    public MyOwnAdapter(Context context,String s1[],String s2[],int image[]){

        ctx=context;
        data1=s1;
        data2=s2;
        img=image;

    }

    @Override
    public MyOwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         LayoutInflater myInflater=LayoutInflater.from(ctx);
         View myOwnView= myInflater.inflate(R.layout.my_row,parent,false);
         return new MyOwnHolder(myOwnView);

    }

    @Override
    public void onBindViewHolder(MyOwnHolder holder, int position) {
       holder.t1.setText(data1[position]);
       holder.t2.setText(data2[position]);
       holder.myImage.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        ImageView myImage;

        public MyOwnHolder(View itemView) {
            super(itemView);
            t1=(TextView) itemView.findViewById(R.id.text_1);
            t2=(TextView) itemView.findViewById(R.id.text_2);
            myImage=(ImageView)itemView.findViewById(R.id.myImage);
        }
    }
}
