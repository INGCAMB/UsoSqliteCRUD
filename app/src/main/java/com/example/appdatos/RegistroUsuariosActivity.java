package com.example.appdatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appdatos.utilidades.Utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoId = findViewById(R.id.campoId);
        campoNombre = findViewById(R.id.campoNombre);
        campoTelefono = findViewById(R.id.campoTelefono);
    }

    public void Registrar(View view){
        //registrarUsuarios();
        registrarUsuariosSql();
    }

    public void registrarUsuariosSql(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        //Insert into usuario (id,nombre,telefono) values (1,Alberto,664);
        String insert="INSERT INTO "+Utilidades.TABLA_USUARIO
                +" ( "
                +Utilidades.CAMPO_ID+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_TELEFONO+")" +
                " VALUEs ("+campoId.getText().toString()+", '"+campoNombre.getText().toString()+"','"
                +campoTelefono.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Usuario registrado",Toast.LENGTH_LONG).show();
        db.close();
    }

    public void registrarUsuarios(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}