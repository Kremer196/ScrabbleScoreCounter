package com.example.scrabblescorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int numberOfPlayers = 2;

    int i = 0;

    private EditText player1;
    private EditText player2;
    private EditText player3;
    private EditText player4;

    private Button newPlayerBtn;
    private Button startGameBtn;

    private DatabaseReference rootRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = findViewById(R.id.MainPlayer1);
        player2 = findViewById(R.id.MainPlayer2);
        player3 = findViewById(R.id.MainPlayer3);
        player4 = findViewById(R.id.MainPlayer4);

        newPlayerBtn = findViewById(R.id.MainNewPlayerBtn);
        startGameBtn = findViewById(R.id.MainStartGameBtn);

        rootRef = FirebaseDatabase.getInstance().getReference();


        newPlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 0) {
                    player3.setVisibility(View.VISIBLE);
                    ++i;
                    return;
                }
                if (i == 1) {
                    player4.setVisibility(View.VISIBLE);
                    ++i;
                    return;
                }
            }
        });

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player1Name = player1.getText().toString();
                String player2Name = player2.getText().toString();
                String player3Name = player3.getText().toString();
                String player4Name = player4.getText().toString();

                rootRef.child("Players").child("Player1").setValue(player1Name);
                rootRef.child("Players").child("Player2").setValue(player2Name);
                rootRef.child("Players").child("Player3").setValue(player3Name);
                rootRef.child("Players").child("Player4").setValue(player4Name);

                startActivity(new Intent(MainActivity.this, SelectOrderActivity.class));

            }


        });


    }
}