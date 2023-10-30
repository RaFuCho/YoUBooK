package com.example.youbook;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

public class acceso_Crud extends AppCompatActivity{


    Spinner spSpinner;
    String[] generos = new String[]{"Masculino", "Femenino"};
    EditText edtuser, edtnombre, edtpass;
    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_usuario);

        edtuser = (EditText) findViewById(R.id.edtuser);
        edtnombre = (EditText) findViewById(R.id.edtnombre);
        edtpass = (EditText) findViewById(R.id.edtpass);
        spSpinner = (Spinner) findViewById(R.id.spSpinner);
        lista = (ListView) findViewById(R.id.Lista);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, generos);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(spinnerAdapter);
        Limpiar();
        cargarLista();
    }

    public void Limpiar(){
        edtuser.setText("");
        edtnombre.setText("");
        edtpass.setText("");
    }

    public void cargarLista(){

        DataHelper dh = new DataHelper(this, "USUARIOS.db", null, 1);
        SQLiteDatabase bd = dh.getReadableDatabase();

        Cursor c = bd.rawQuery("Select USER, NOM, GEN, PASS from USUARIOS", null);
        String[] arr = new String[c.getCount()];

        if(c.moveToFirst() == true){
            int i = 0;
            do{
                String linea = "||"+ c.getString(0) + "||" + c.getString(1) + "||" + c.getString(2) +"||"+ c.getString(3) + "||";
                arr[i] = linea;
                i++;

            }while(c.moveToNext() == true);


            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
            lista.setAdapter(adaptador);
            bd.close();
        }
    }

    public void clickagregar(View view){

        DataHelper dh = new DataHelper(this, "USUARIOS.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();

        ContentValues reg = new ContentValues();

        reg.put("USER", edtuser.getText().toString());
        reg.put("NOM", edtnombre.getText().toString());
        reg.put("PASS", edtpass.getText().toString());

        reg.put("GEN", spSpinner.getSelectedItem().toString());

        long resp = bd.insert("USUARIOS", null, reg);

        bd.close();

        if(resp == -1){
            Toast.makeText(this, "No se puede ingresar el registro", Toast.LENGTH_SHORT).show();
        }else {Toast.makeText(this, "Registro agregado con exito", Toast.LENGTH_SHORT).show();}

        Limpiar();
        cargarLista();
    }

    public void clickmodificar(View view){

        DataHelper dh = new DataHelper(this, "USUARIOS.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();

        ContentValues reg = new ContentValues();

        reg.put("USER", edtuser.getText().toString());
        reg.put("NOM", edtnombre.getText().toString());
        reg.put("PASS", edtpass.getText().toString());

        reg.put("GEN", spSpinner.getSelectedItem().toString());

        long resp = bd.update("USUARIOS", reg, "USER=?", new String[]{edtuser.getText().toString()});

        bd.close();

        if(resp == -1){
            Toast.makeText(this, "Registro no se pudo modificar", Toast.LENGTH_SHORT).show();
        }else {Toast.makeText(this, "Registro modificado con exito", Toast.LENGTH_SHORT).show();}

        Limpiar();
        cargarLista();
    }

    public void clickeliminar(View view){
        DataHelper dh = new DataHelper(this, "USUARIOS.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();

        String bUser = edtuser.getText().toString();

        long resp = bd.delete("USUARIOS", "USER='" + bUser + "'", null);
        bd.close();

        if(resp==-1){
            Toast.makeText(this, "Registro no encontrado", Toast.LENGTH_SHORT).show();
        }else {Toast.makeText(this, "Registro eliminado con exito", Toast.LENGTH_SHORT).show();}

        Limpiar();
        cargarLista();
    }
}
