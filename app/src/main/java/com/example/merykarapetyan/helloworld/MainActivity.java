package com.example.merykarapetyan.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    TextView text_to_change; //event_listener
    Button button1;          //event_source
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    EditText input_text;
    public static final int requestCode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
      //  String appName = getString(R.string.app_name);

        Toast.makeText(this, "WELCOME", Toast.LENGTH_SHORT).show();

        text_to_change = (TextView) findViewById(R.id.textview1);

        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);
        button4=(Button)findViewById(R.id.button_next2);
        button5=(Button)findViewById(R.id.button_next3);


        button1.setOnClickListener(new OnClickListener1());
        button2.setOnClickListener(new OnClickListener2());
        button3.setOnClickListener(new OnClickListener3());
        button4.setOnClickListener(new OnClickListener4());
        button5.setOnClickListener(new OnClickListener5());



        input_text = (EditText) findViewById(R.id.input_text);



        //context_menu 4->

        //registering input_text with context menu
        registerForContextMenu(input_text);

        registerForContextMenu(button1);

        //<-4


    }




    private class OnClickListener1 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            text_to_change.setText("this is button1");
        }
    }

    private class OnClickListener2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String s=input_text.getText().toString();
            text_to_change.setText(s);
        }
    }

    private class OnClickListener3 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
            intent1.putExtra("user", input_text.getText().toString());//1
            //1 intent1.setData(Uri.parse("http://www.google.com"));

            //0,1 startActivity(intent1);


            startActivityForResult(intent1,1);

        }
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) { // Identify activity
            if (resultCode == RESULT_OK) { // Activity succeeded
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                text_to_change.setText(reply);
            }
        }
    }

    private class OnClickListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,ThirdActivity.class);
            startActivity(intent);
        }
    }



    //option_menu 4->

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);//inflates xml file into java file
        return true;    //so that you can see option menu at the top
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.button_settings:
                Toast.makeText(this,"You clicked settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_speak:
                Toast.makeText(this,"You clicked speak",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_status:
                Toast.makeText(this,"You clicked status",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    //context_menu 4->

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch(v.getId()){
            case R.id.input_text:
                getMenuInflater().inflate(R.menu.context_menu,menu);
            break;
            case R.id.button_1:
                 getMenuInflater().inflate(R.menu.context_menu,menu);
            break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.i1:
                Toast.makeText(this, "You clicked item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2:
                Toast.makeText(this, "You clicked item2", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    //<-4

    //for RecyclerView 5->

    private class OnClickListener5 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,FourthActivity.class);
            startActivity(intent);
        }
    }


    //<- 5







    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
       // Toast.makeText(this, "START", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
       //Toast.makeText(this, "RESUME", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

}
