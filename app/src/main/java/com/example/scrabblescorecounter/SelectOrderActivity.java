package com.example.scrabblescorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;

public class SelectOrderActivity extends AppCompatActivity {

    private TextView player1;
    private TextView player2;
    private TextView player3;
    private TextView player4;

    private ImageButton player1Up;
    private ImageButton player1Down;

    private ImageButton player2Up;
    private ImageButton player2Down;

    private ImageButton player3Up;
    private ImageButton player3Down;

    private ImageButton player4Up;
    private ImageButton player4Down;

    private Button continueBtn;

    private int countPlayers = 1;
    private DatabaseReference rootRef;

    private DatabaseReference scoreRef;
    private DatabaseReference wordsRef;


    int numOfPlayers;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_selection_activity);

        player1 = findViewById(R.id.OrderPlayer1);
        player2 = findViewById(R.id.OrderPlayer2);
        player3 = findViewById(R.id.OrderPlayer3);
        player4 = findViewById(R.id.OrderPlayer4);

        player1Up = findViewById(R.id.Player1ArrowUp);
        player1Down = findViewById(R.id.Player1ArrowDown);

        player2Up = findViewById(R.id.Player2ArrowUp);
        player2Down = findViewById(R.id.Player2ArrowDown);

        player3Up = findViewById(R.id.Player3ArrowUp);
        player3Down = findViewById(R.id.Player3ArrowDown);

        player4Up = findViewById(R.id.Player4ArrowUp);
        player4Down = findViewById(R.id.Player4ArrowDown);

        continueBtn = findViewById(R.id.OrderActivityContinueBtn);

        rootRef = FirebaseDatabase.getInstance().getReference().child("Players");
        scoreRef = FirebaseDatabase.getInstance().getReference().child("Scores");
        wordsRef = FirebaseDatabase.getInstance().getReference().child("Words");

       rootRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               updateActivity(snapshot);
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

        player1Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!player3.getText().toString().isEmpty() && !player4.getText().toString().isEmpty()) {
                    String player4String = player4.getText().toString();
                    player4.setText(player1.getText());
                    player1.setText(player4String);
                } else if(!player3.getText().toString().isEmpty()) {
                    String player3String = player3.getText().toString();
                    player3.setText(player1.getText());
                    player1.setText(player3String);
                } else {
                    String player2String = player2.getText().toString();
                    player2.setText(player1.getText());
                    player1.setText(player2String);
                }
            }
        });


        player1Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player2String = player2.getText().toString();
                player2.setText(player1.getText());
                player1.setText(player2String);
            }
        });

        player2Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player2String = player2.getText().toString();
                player2.setText(player1.getText());
                player1.setText(player2String);
            }
        });

        player2Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!player3.getText().toString().isEmpty()) {
                    String player2String = player2.getText().toString();
                    player2.setText(player3.getText());
                    player3.setText(player2String);
                } else {
                    String player2String = player2.getText().toString();
                    player2.setText(player1.getText());
                    player1.setText(player2String);
                }
            }
        });


        player3Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player3String = player3.getText().toString();
                player3.setText(player2.getText());
                player2.setText(player3String);
            }
        });

        player3Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!player4.getText().toString().isEmpty()) {
                    String player3String = player3.getText().toString();
                    player3.setText(player4.getText());
                    player4.setText(player3String);
                } else {
                    String player3String = player3.getText().toString();
                    player3.setText(player1.getText());
                    player1.setText(player3String);
                }
            }
        });

        player4Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player4String = player4.getText().toString();
                player4.setText(player3.getText());
                player3.setText(player4String);
            }
        });

        player4Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player4String = player4.getText().toString();
                player4.setText(player1.getText());
                player1.setText(player4String);
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               updateDatabase();
               startActivity(new Intent(SelectOrderActivity.this, Player1.class));
            }
        });

    }

    private void updateDatabase() {
       rootRef.child("Player1").setValue(player1.getText().toString());
       rootRef.child("Player2").setValue(player2.getText().toString());
       rootRef.child("Player3").setValue(player3.getText().toString());
       rootRef.child("Player4").setValue(player4.getText().toString());

       scoreRef.child("Player1").setValue(0);
       scoreRef.child("Player2").setValue(0);
       scoreRef.child("Player3").setValue(0);
       scoreRef.child("Player4").setValue(0);

       wordsRef.child("Player1").setValue("");
       wordsRef.child("Player2").setValue("");
       wordsRef.child("Player3").setValue("");
       wordsRef.child("Player4").setValue("");
    }


    private void updateActivity(DataSnapshot snapshot) {

       player1.setText(snapshot.child("Player1").getValue().toString());
       player2.setText(snapshot.child("Player2").getValue().toString());


       if(!snapshot.child("Player3").getValue().toString().isEmpty()) {
           player3.setText(snapshot.child("Player3").getValue().toString());
           player3.setVisibility(View.VISIBLE);
           player3Up.setVisibility(View.VISIBLE);
           player3Down.setVisibility(View.VISIBLE);

       }

        if(!snapshot.child("Player4").getValue().toString().isEmpty()) {
            player4.setText(snapshot.child("Player4").getValue().toString());
            player4.setVisibility(View.VISIBLE);
            player4Up.setVisibility(View.VISIBLE);
            player4Down.setVisibility(View.VISIBLE);

        }



    }
}
