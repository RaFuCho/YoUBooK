package com.example.youbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class acceso_Ficcion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_categoria_ficcion);
    }

    public void accesoSolicitud(View view){
        Intent intent = new Intent(this , acceso_Solicitud.class);
        startActivity(intent);
    }


}
