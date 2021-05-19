package com.example.scrabblescorecounter;

import android.content.Intent;
import android.os.Bundle;
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

public class Player1 extends AppCompatActivity {

    private Button doubleLetter;
    private Button tripleLetter;
    private Button doubleWord;
    private Button tripleWord;

    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private Button E;
    private Button F;
    private Button G;
    private Button H;
    private Button I;
    private Button J;
    private Button K;
    private Button L;
    private Button M;
    private Button N;
    private Button O;
    private Button P;
    private Button letterR;
    private Button S;
    private Button T;
    private Button U;
    private Button V;
    private Button Z;
    private Button Ž;
    private Button Č;
    private Button Ć;
    private Button Đ;
    private Button DŽ;
    private Button Š;
    private Button LJ;
    private Button NJ;

    private TextView score;
    private TextView word;

    private Button clear;
    private Button calculate;
    private Button player2Next;
    private Button player3Next;
    private Button player4Next;

    private DatabaseReference dataRef;
    private DatabaseReference scoreRef;
    private DatabaseReference wordRef;

    private TextView player1;

    private TextView scoreByPoint;

    private int wordScore = 0;

    private int scoreGetter;

    private Button endGameBtn;


    private DatabaseReference player2NameRef;
    private DatabaseReference player3NameRef;
    private DatabaseReference player4NameRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player1);

        doubleLetter = findViewById(R.id.DoubleLetterPlayer1);
        tripleLetter = findViewById(R.id.TripleLetterPlayer1);
        doubleWord = findViewById(R.id.DoubleWordPlayer1);
        tripleWord = findViewById(R.id.TripleWordPlayer1);

        A = findViewById(R.id.letterAp1);
        B = findViewById(R.id.letterBp1);
        C = findViewById(R.id.letterCp1);
        D = findViewById(R.id.letterDp1);
        E = findViewById(R.id.letterEp1);
        F = findViewById(R.id.letterFp1);
        G = findViewById(R.id.letterGp1);
        H = findViewById(R.id.letterHp1);
        I = findViewById(R.id.letterIp1);
        J = findViewById(R.id.letterJp1);
        K = findViewById(R.id.letterKp1);
        L = findViewById(R.id.letterLp1);
        M = findViewById(R.id.letterMp1);
        N = findViewById(R.id.letterNp1);
        O = findViewById(R.id.letterOp1);
        P = findViewById(R.id.letterPp1);
        letterR = findViewById(R.id.letterRp1);
        S = findViewById(R.id.letterSp1);
        T = findViewById(R.id.letterTp1);
        U = findViewById(R.id.letterUp1);
        V = findViewById(R.id.letterVp1);
        Z = findViewById(R.id.letterZp1);
        Ž = findViewById(R.id.letterŽp1);
        Č = findViewById(R.id.letterČp1);
        Ć = findViewById(R.id.letterĆp1);
        Đ = findViewById(R.id.letterĐp1);
        DŽ = findViewById(R.id.letterDŽp1);
        Š = findViewById(R.id.letterŠp1);
        NJ = findViewById(R.id.letterNJp1);
        LJ = findViewById(R.id.letterLJp1);

        score = findViewById(R.id.Player1WordScore);
        word = findViewById(R.id.UserWordPlayer1);

        clear = findViewById(R.id.Player1ClearBtn);
        calculate = findViewById(R.id.Player1Calculate);
        player2Next = findViewById(R.id.Player2NextBtnp1);
        player3Next = findViewById(R.id.Player3NextBtnp1);
        player4Next = findViewById(R.id.Player4NextBtnp1);

        endGameBtn = findViewById(R.id.Player1EndGameBtn);

        player1 = findViewById(R.id.Player1);

        scoreByPoint = findViewById(R.id.Player1UserInputLetter);

        dataRef = FirebaseDatabase.getInstance().getReference().child("Players").child("Player1");
        scoreRef = FirebaseDatabase.getInstance().getReference().child("Scores").child("Player1");
        wordRef = FirebaseDatabase.getInstance().getReference().child("Words").child("Player1");

        player2NameRef = FirebaseDatabase.getInstance().getReference().child("Players").child("Player2");
        player2NameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                player2Next.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        player3NameRef = FirebaseDatabase.getInstance().getReference().child("Players").child("Player3");
        player3NameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().isEmpty()) {
                    player3Next.setVisibility(View.INVISIBLE);
                    player3Next.setClickable(false);
                } else {
                    player3Next.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        player4NameRef = FirebaseDatabase.getInstance().getReference().child("Players").child("Player4");
        player4NameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().isEmpty()) {
                    player4Next.setVisibility(View.INVISIBLE);
                    player4Next.setClickable(false);
                } else {
                    player4Next.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                player1.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        scoreRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                scoreGetter = Integer.parseInt(snapshot.getValue().toString().trim());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("a");
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("3");
                word.append("b");
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("4");
                word.append("c");
            }
        });

        Č.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("3");
                word.append("č");
            }
        });

        Ć.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("5");
                word.append("ć");
            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("3");
                word.append("d");
            }
        });

        DŽ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("10");
                word.append("dž");
            }
        });


        Đ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("10");
                word.append("đ");
            }
        });

        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("e");
            }
        });

        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("8");
                word.append("f");
            }
        });

        G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("3");
                word.append("g");
            }
        });

        H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("4");
                word.append("h");
            }
        });

        I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("i");
            }
        });

        J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("j");
            }
        });

        K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("2");
                word.append("k");
            }
        });

        L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("3");
                word.append("l");
            }
        });

        LJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("4");
                word.append("lj");
            }
        });

        M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("2");
                word.append("m");
            }
        });

        N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("n");
            }
        });

        NJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("4");
                word.append("nj");
            }
        });

        O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("o");
            }
        });

        P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("2");
                word.append("p");
            }
        });

        letterR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("r");
            }
        });

        S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("s");
            }
        });

        Š.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("4");
                word.append("š");
            }
        });

        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("t");
            }
        });

        U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("1");
                word.append("u");
            }
        });

        V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("2");
                word.append("v");
            }
        });

        Z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("3");
                word.append("z");
            }
        });

        Ž.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreByPoint.setText("");
                scoreByPoint.setText("4");
                word.append("ž");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordScore = 0;
                word.setText("");
                score.setText("0");
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!scoreByPoint.getText().toString().isEmpty()) {
                    wordScore += Integer.parseInt(scoreByPoint.getText().toString().trim());
                    score.setText(String.valueOf(wordScore));
                }
            }
        });


        doubleLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!scoreByPoint.getText().toString().isEmpty()) {
                    int doubled = Integer.parseInt(scoreByPoint.getText().toString().trim()) * 2;
                    scoreByPoint.setText(String.valueOf(doubled));
                }
            }
        });

        tripleLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!scoreByPoint.getText().toString().isEmpty()) {
                    int tripled = Integer.parseInt(scoreByPoint.getText().toString().trim()) * 3;
                    scoreByPoint.setText(String.valueOf(tripled));
                }
            }
        });

        doubleWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!scoreByPoint.getText().toString().isEmpty()) {
                    int doubledWord = Integer.parseInt(score.getText().toString().trim()) * 2;
                    score.setText(String.valueOf(doubledWord));
                }
            }
        });

        tripleWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!scoreByPoint.getText().toString().isEmpty()) {
                    int tripledWord = Integer.parseInt(score.getText().toString().trim()) * 3;
                    score.setText(String.valueOf(tripledWord));
                }
            }
        });

        player2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreTotal = scoreGetter + Integer.parseInt(score.getText().toString().trim());
                scoreRef.setValue(String.valueOf(scoreTotal));
                storeWord(Integer.parseInt(score.getText().toString().trim()));
                startActivity(new Intent(Player1.this, Player2.class));
            }
        });

        player3Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreTotal = scoreGetter + Integer.parseInt(score.getText().toString().trim());
                scoreRef.setValue(String.valueOf(scoreTotal));
                storeWord(Integer.parseInt(score.getText().toString().trim()));
                startActivity(new Intent(Player1.this, Player3.class));
            }
        });

        player4Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreTotal = scoreGetter + Integer.parseInt(score.getText().toString().trim());
                scoreRef.setValue(String.valueOf(scoreTotal));
                storeWord(Integer.parseInt(score.getText().toString().trim()));
                startActivity(new Intent(Player1.this, Player4.class));
            }
        });


        endGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Player1.this, EndGameActivity.class));
            }
        });


    }

    private void storeWord(int addScore) {
        wordRef.push().setValue(word.getText().toString() + " - " + String.valueOf(addScore));
    }

}
