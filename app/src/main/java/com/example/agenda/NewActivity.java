package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.db.DBContactos;

public class NewActivity extends AppCompatActivity {
    EditText editTextNombre, editTextTelefono, editTextEmail;
    Button BtnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextEmail = findViewById(R.id.editTextEmail);
        BtnGuardar = findViewById(R.id.BtnGuardar);

        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ptm");
                DBContactos dbContactos = new DBContactos(NewActivity.this);
                long id = dbContactos.insertContacts(
                        editTextNombre.getText().toString(),
                        editTextTelefono.getText().toString(),
                        editTextEmail.getText().toString());
                if(id>0){
                    Toast.makeText(NewActivity.this, "Registro guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(NewActivity.this, "Error en el registro", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        editTextNombre.setText("");
        editTextEmail.setText("");
        editTextTelefono.setText("");
    }
}
