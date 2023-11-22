package com.example.chilefutbol;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin, buttonGoToRegister;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editTextUsername = findViewById(R.id.editTextLoginUsername);
        editTextPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonGoToRegister = findViewById(R.id.buttonGoToRegister);

        // Abrir o crear la base de datos
        db = openOrCreateDatabase("UsuariosDB", MODE_PRIVATE, null);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Verificar las credenciales en la base de datos
                if (loginUser(username, password)) {
                    // Inicio de sesión exitoso, realizar acciones adicionales o navegar a otra actividad
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    // Por ejemplo, puedes navegar a la actividad del menú
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Cierra la actividad actual para evitar volver atrás
                } else {
                    // Credenciales incorrectas, mostrar un mensaje de error
                    Toast.makeText(LoginActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a la actividad de registro
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para verificar las credenciales del usuario en la base de datos
    private boolean loginUser(String username, String password) {
        String[] columns = {"id"};
        String selection = "nombre=? AND contrasena=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("usuarios", columns, selection, selectionArgs, null, null, null);

        int count = cursor.getCount();
        cursor.close();

        return count > 0;
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
