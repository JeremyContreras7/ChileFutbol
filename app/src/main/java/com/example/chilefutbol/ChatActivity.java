package com.example.chilefutbol;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private DatabaseReference chatRef;
    private FirebaseAuth mAuth;
    private ArrayAdapter<String> chatAdapter;
    private List<String> chatMessages;
    private EditText messageEditText;
    private String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            // Manejar el caso en que el usuario no esté autenticado
            return;
        }

        currentUsername = currentUser.getEmail();

        chatRef = FirebaseDatabase.getInstance().getReference("chats");

        chatMessages = new ArrayList<>();
        chatAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chatMessages);

        ListView chatListView = findViewById(R.id.listViewChat);
        chatListView.setAdapter(chatAdapter);

        messageEditText = findViewById(R.id.editTextMessage);

        Button sendMessageButton = findViewById(R.id.btnSendMessage);
        sendMessageButton.setOnClickListener(v -> sendMessage());

        chatRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                chatMessages.clear();
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    String message = messageSnapshot.getValue(String.class);
                    chatMessages.add(message);
                }
                chatAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Manejar errores de lectura de datos
            }
        });
    }

    private void sendMessage() {
        String message = messageEditText.getText().toString();
        if (!message.isEmpty()) {
            chatRef.push().setValue(currentUsername + ": " + message);
            messageEditText.getText().clear();
        } else {
            Toast.makeText(this, "Por favor, ingrese un mensaje", Toast.LENGTH_SHORT).show();
        }
    }
}
