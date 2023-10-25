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

import com.example.chilefutbol.MainActivity;
import com.example.chilefutbol.R;
import com.example.chilefutbol.RegistroActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class LoginActivity extends AppCompatActivity {
    private Button boton1;
    private Button boton2;
    private Button botoningresar;
    private EditText usuario;
    private EditText contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        boton1 = findViewById(R.id.btnirRegistro);
        boton2 = findViewById(R.id.btnSaltar);
        botoningresar = findViewById(R.id.btningreso);
        usuario = findViewById(R.id.txtusuario);
        contrasena = findViewById(R.id.txtcontrasena);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(intent);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        botoningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuarioIngresado = usuario.getText().toString();
                String contrasenaIngresada = contrasena.getText().toString();

                if (verificarUsuario(usuarioIngresado, contrasenaIngresada)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean verificarUsuario(String usuario, String contrasena) {
        // Asegúrate de que la variable db esté correctamente inicializada
        SQLiteDatabase db = openOrCreateDatabase("UsuariosDB", MODE_PRIVATE, null);

        String consulta = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
        String[] argumentos = {usuario, contrasena};
        Cursor cursor = db.rawQuery(consulta, argumentos);
        boolean usuarioCorrecto = cursor.moveToFirst();
        cursor.close();

        // Cierra la base de datos después de usarla
        db.close();

        return usuarioCorrecto;
    }

}

