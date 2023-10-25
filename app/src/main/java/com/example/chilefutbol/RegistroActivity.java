package com.example.chilefutbol;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {
    private Button boton1;
    private EditText nombre;
    private EditText apellido;
    private EditText correo;
    private EditText contrasena;
    private Button boton2;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        boton1 = findViewById(R.id.btnvolverregistro);
        nombre = findViewById(R.id.txtnombre);
        apellido = findViewById(R.id.txtapellido);
        correo = findViewById(R.id.txtcorreo);
        contrasena = findViewById(R.id.txtcontrasena1);
        boton2 = findViewById(R.id.btnregistrar);

        // Abrir o crear la base de datos
        db = openOrCreateDatabase("UsuariosDB", MODE_PRIVATE, null);

        // Crear la tabla si no existe
        db.execSQL("CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "apellido TEXT," +
                "correo TEXT," +
                "contrasena TEXT);");

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los datos ingresados por el usuario
                String nombreUsuario = nombre.getText().toString();
                String contrasenaUsuario = contrasena.getText().toString();
                String correoUsuario = correo.getText().toString();
                String apellidoUsuario = apellido.getText().toString();

                // Crear un nuevo registro de usuario
                ContentValues values = new ContentValues();
                values.put("nombre", nombreUsuario);
                values.put("apellido", apellidoUsuario);
                values.put("correo", correoUsuario);
                values.put("contrasena", contrasenaUsuario);

                // Insertar el nuevo usuario en la base de datos
                long newRowId = db.insert("usuarios", null, values);

                // Verificar el resultado de la inserción
                if (newRowId != -1) {
                    // La inserción fue exitosa, mostrar un mensaje de éxito o realizar acciones adicionales
                    Toast.makeText(RegistroActivity.this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    // Ocurrió un error durante la inserción, mostrar un mensaje de error
                    Toast.makeText(RegistroActivity.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cerrar la base de datos al destruir la actividad
        if (db != null) {
            db.close();
        }
    }
}