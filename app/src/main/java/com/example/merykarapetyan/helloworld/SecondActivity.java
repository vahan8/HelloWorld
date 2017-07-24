package com.example.merykarapetyan.helloworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG =SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "user1";

    TextView text;

    Button button_call;
    Button button_map;

    Button button_exit;
    ToggleButton toggle_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i(TAG, "onCreate_2: ");

        text=(TextView)findViewById(R.id.title);

        Bundle bundle1=getIntent().getExtras();//everythig  which wwe have transferred from the 1st act. to 2nd //1
        String s1=bundle1.getString("user");//1
       // or just String:   String  s1=getIntent().getStringExtra("user");

        text.setText(s1);//1

                    //1 Uri s1=getIntent().getData();
                    //1  text.setText(s1.toString());



        button_call = (Button) findViewById(R.id.button_call);
        button_map = (Button) findViewById(R.id.button_map);

        button_call.setOnClickListener(new OnClickListener());
        button_map .setOnClickListener(new OnClickListener());

        //user input controls 3.->
        button_exit=(Button)findViewById(R.id.button_exit) ;
        toggle_button=(ToggleButton) findViewById(R.id.toggleButton) ;


        toggle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggle_button.isChecked()){
                    Toast.makeText(SecondActivity.this,"You turned ON the button",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SecondActivity.this,"You turned OFF the button",Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog=new AlertDialog.Builder(SecondActivity.this);
                alertDialog.setTitle("EXIT");
                alertDialog.setMessage("Are you sure ?");

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.setCancelable(false); //you can`t exit clicking outside
                alertDialog.show();
            }
        });

        //<-3


        //returning
        Intent replyIntent=new Intent();
        replyIntent.putExtra(EXTRA_REPLY,"ok");
        setResult(RESULT_OK,replyIntent);
    }



    private class OnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view){
            switch(view.getId()) {

                case R.id.button_call:
                    Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:78645432"));
                    if (intent2.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent2);
                    }
                    break;

                case R.id.button_map:
                    Intent  intent3=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:48.8014,2.1301"));
                    if (intent3.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent3);
                    }
                    break;
            }
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart_2: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume_2: ");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause_2: ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop_2: ");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy_2: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart_2: ");
    }


}
