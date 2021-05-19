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


public class Player4 extends AppCompatActivity {

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
    private Button player1Next;
    private Button player2Next;
    private Button player3Next;

    private DatabaseReference dataRef;
    private DatabaseReference scoreRef;
    private DatabaseReference wordRef;

    private TextView player4;

    private TextView scoreByPoint;

    private Button endGameBtn;

    private int wordScore = 0;

    private int scoreGetter;

    private DatabaseReference player1NameRef;
    private DatabaseReference player2NameRef;
    private DatabaseReference player3NameRef;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player4);


        doubleLetter = findViewById(R.id.DoubleLetterPlayer4);
        tripleLetter = findViewById(R.id.TripleLetterPlayer4);
        doubleWord = findViewById(R.id.DoubleWordPlayer4);
        tripleWord = findViewById(R.id.TripleWordPlayer4);

        A = findViewById(R.id.letterAp4);
        B = findViewById(R.id.letterBp4);
        C = findViewById(R.id.letterCp4);
        D = findViewById(R.id.letterDp4);
        E = findViewById(R.id.letterEp4);
        F = findViewById(R.id.letterFp4);
        G = findViewById(R.id.letterGp4);
        H = findViewById(R.id.letterHp4);
        I = findViewById(R.id.letterIp4);
        J = findViewById(R.id.letterJp4);
        K = findViewById(R.id.letterKp4);
        L = findViewById(R.id.letterLp4);
        M = findViewById(R.id.letterMp4);
        N = findViewById(R.id.letterNp4);
        O = findViewById(R.id.letterOp4);
        P = findViewById(R.id.letterPp4);
        letterR = findViewById(R.id.letterRp4);
        S = findViewById(R.id.letterSp4);
        T = findViewById(R.id.letterTp4);
        U = findViewById(R.id.letterUp4);
        V = findViewById(R.id.letterVp4);
        Z = findViewById(R.id.letterZp4);
        Ž = findViewById(R.id.letterŽp4);
        Č = findViewById(R.id.letterČp4);
        Ć = findViewById(R.id.letterĆp4);
        Đ = findViewById(R.id.letterĐp4);
        DŽ = findViewById(R.id.letterDŽp4);
        Š = findViewById(R.id.letterŠp4);
        NJ = findViewById(R.id.letterNJp4);
        LJ = findViewById(R.id.letterLJp4);

        score = findViewById(R.id.Player4WordScore);
        word = findViewById(R.id.UserWordPlayer4);

        clear = findViewById(R.id.Player4ClearBtn);
        calculate = findViewById(R.id.Player4Calculate);
        player1Next = findViewById(R.id.Player1NextBtnp4);
        player2Next = findViewById(R.id.Player2NextBtnp4);
        player3Next = findViewById(R.id.Player3NextBtnp4);

        player4 = findViewById(R.id.Player4);

        endGameBtn = findViewById(R.id.Player4EndGameBtn);

        scoreByPoint = findViewById(R.id.Player4UserInputLetter);

        dataRef = FirebaseDatabase.getInstance().getReference().child("Players").child("Player4");
        scoreRef = FirebaseDatabase.getInstance().getReference().child("Scores").child("Player4");
        wordRef = FirebaseDatabase.getInstance().getReference().child("Words").child("Player4");

        player1NameRef = FirebaseDatabase.getInstance().getReference().child("Players").child("Player1");
        player1NameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                player1Next.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


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
                player3Next.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                player4.setText(snapshot.getValue().toString());
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

        player1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreTotal = scoreGetter + Integer.parseInt(score.getText().toString().trim());
                scoreRef.setValue(String.valueOf(scoreTotal));
                storeWord(Integer.parseInt(score.getText().toString().trim()));
                startActivity(new Intent(Player4.this, Player1.class));
            }
        });

        player2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreTotal = scoreGetter + Integer.parseInt(score.getText().toString().trim());
                scoreRef.setValue(String.valueOf(scoreTotal));
                storeWord(Integer.parseInt(score.getText().toString().trim()));
                startActivity(new Intent(Player4.this, Player2.class));
            }
        });

        player3Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreTotal = scoreGetter + Integer.parseInt(score.getText().toString().trim());
                scoreRef.setValue(String.valueOf(scoreTotal));
                storeWord(Integer.parseInt(score.getText().toString().trim()));
                startActivity(new Intent(Player4.this, Player3.class));
            }
        });

        endGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Player4.this, EndGameActivity.class));
            }
        });

    }

    private void storeWord(int addScore) {
        wordRef.push().setValue(word.getText().toString() + " - " + String.valueOf(addScore));
    }
}
