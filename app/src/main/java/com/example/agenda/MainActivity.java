package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.agenda.adaptadores.ListaContactosAdapter;
import com.example.agenda.db.DBContactos;
import com.example.agenda.db.DBHelper;
import com.example.agenda.entidades.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listaContactos;
    ArrayList<Contacto> listaArrayContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContactos = findViewById(R.id.rvLista);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));
        DBContactos dbContactos = new DBContactos(MainActivity.this);
        listaArrayContactos = new ArrayList<>();
        ListaContactosAdapter adapter = new ListaContactosAdapter(dbContactos.MostrarContactos());
        listaContactos.setAdapter(adapter);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void nuevoRegistro(){
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }
}