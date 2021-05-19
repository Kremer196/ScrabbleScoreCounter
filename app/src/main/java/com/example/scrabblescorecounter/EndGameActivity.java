package com.example.scrabblescorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EndGameActivity extends AppCompatActivity {

    private TextView player1;
    private TextView player2;
    private TextView player3;
    private TextView player4;

    private TextView score1;
    private TextView score2;
    private TextView score3;
    private TextView score4;

    private Button newGameBtn;

    private DatabaseReference nameRef;
    private DatabaseReference scoreRef;

    private DatabaseReference player1NameRef;
    private DatabaseReference player2NameRef;
    private DatabaseReference player3NameRef;
    private DatabaseReference player4NameRef;

    private DatabaseReference player1ScoreRef;
    private DatabaseReference player2ScoreRef;
    private DatabaseReference player3ScoreRef;
    private DatabaseReference player4ScoreRef;

    private Button player1Words;
    private Button player2Words;
    private Button player3Words;
    private Button player4Words;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame_activity);


        player1 = findViewById(R.id.EndPlayer1);
        player2 = findViewById(R.id.EndPlayer2);
        player3 = findViewById(R.id.EndPlayer3);
        player4 = findViewById(R.id.EndPlayer4);

        score1 = findViewById(R.id.EndScore1);
        score2 = findViewById(R.id.EndScore2);
        score3 = findViewById(R.id.EndScore3);
        score4 = findViewById(R.id.EndScore4);

        player1Words = findViewById(R.id.Player1Words);
        player2Words = findViewById(R.id.Player2Words);
        player3Words = findViewById(R.id.Player3Words);
        player4Words = findViewById(R.id.Player4Words);



        newGameBtn = findViewById(R.id.EndNewGameBtn);

        nameRef = FirebaseDatabase.getInstance().getReference().child("Players");
        scoreRef = FirebaseDatabase.getInstance().getReference().child("Scores");


        player1NameRef = nameRef.child("Player1");

        player1NameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                player1.setText(snapshot.getValue().toString());
                player1Words.setText(snapshot.getValue().toString() + "'s Words");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        player2NameRef = nameRef.child("Player2");

        player2NameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                player2.setText(snapshot.getValue().toString());
                player2Words.setText(snapshot.getValue().toString() + "'s Words");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        player3NameRef = nameRef.child("Player3");

        player3NameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().isEmpty()) {
                    score3.setVisibility(View.INVISIBLE);
                    player3Words.setVisibility(View.INVISIBLE);
                    player3Words.setClickable(false);
                }
                player3.setText(snapshot.getValue().toString());
                player3Words.setText(snapshot.getValue().toString() + "'s Words");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        player4NameRef = nameRef.child("Player4");

        player4NameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().isEmpty()) {
                    score4.setVisibility(View.INVISIBLE);
                    player4Words.setVisibility(View.INVISIBLE);
                    player4Words.setClickable(false);
                }
                player4.setText(snapshot.getValue().toString());
                player4Words.setText(snapshot.getValue().toString() + "'s Words");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        player1ScoreRef = scoreRef.child("Player1");
        player2ScoreRef = scoreRef.child("Player2");
        player3ScoreRef = scoreRef.child("Player3");
        player4ScoreRef = scoreRef.child("Player4");

        player1ScoreRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                score1.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        player2ScoreRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                score2.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        player3ScoreRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                score3.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        player4ScoreRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                score4.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        player1Words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndGameActivity.this, Player1Words.class));
            }
        });

        player2Words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndGameActivity.this, Player2Words.class));
            }
        });

        player3Words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndGameActivity.this, Player3Words.class));
            }
        });

        player4Words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndGameActivity.this, Player4Words.class));
            }
        });





        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndGameActivity.this, MainActivity.class));
            }
        });

    }
}
