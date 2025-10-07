package com.example.appdatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios", null, 1);
    }

    public void Menu(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.btnRegistro:
                i = new Intent(MainActivity.this,RegistroUsuariosActivity.class);
                break;
            case R.id.btnConsultarUsuario:
                i = new Intent(MainActivity.this,ConsultarUsuariosActivity.class);
                break;
            case R.id.btnConsultarListaUsuario:
                break;
            case R.id.btnConsultarListaUsuarioListview:
                break;
        }
        if (i != null){
            startActivity(i);
        }
    }
}