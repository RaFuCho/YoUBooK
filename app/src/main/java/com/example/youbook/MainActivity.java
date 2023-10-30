package com.example.youbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        textView = findViewById(R.id.Textview);
        imageView = findViewById(R.id.imageView);

        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();
    }

    public class MyAsyncTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids){
            try {
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return "Operacion completa";
        }

        @Override
        protected void onPostExecute(String result){

            textView.setText(result);
            setContentView(R.layout.activity_main);
        }
    }


    public void onClickaccesoCrud(View view){
        Intent intent = new Intent(this, acceso_Crud.class);
        startActivity(intent);
    }

    public void acceso_Principal(View view){
        Intent intent = new Intent(this, acceso_Principal.class);
        startActivity(intent);
    }


}