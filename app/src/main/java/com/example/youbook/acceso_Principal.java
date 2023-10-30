package com.example.youbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class acceso_Principal extends AppCompatActivity {



    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_seccion_principal);
    }

    public void accesoFiccion(View view){

        Intent intent = new Intent(this, acceso_Ficcion.class);
        startActivity(intent);
    }

    public void clickaccesoMapa(View view){
        Intent intent = new Intent(this, acceso_Mapa.class);
        startActivity(intent);
    }

}
