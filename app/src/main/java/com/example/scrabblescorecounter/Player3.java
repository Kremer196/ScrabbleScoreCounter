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

public class Player3  extends AppCompatActivity {

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
    private Button player4Next;

    private DatabaseReference dataRef;
    private DatabaseReference scoreRef;
    private DatabaseReference wordRef;

    private TextView player3;

    private TextView scoreByPoint;

    private Button endGameBtn;

    private int wordScore = 0;

    private int scoreGetter;

    private DatabaseReference player1NameRef;
    private DatabaseReference player2NameRef;
    private DatabaseReference player4NameRef;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player3);

        doubleLetter = findViewById(R.id.DoubleLetterPlayer3);
        tripleLetter = findViewById(R.id.TripleLetterPlayer3);
        doubleWord = findViewById(R.id.DoubleWordPlayer3);
        tripleWord = findViewById(R.id.TripleWordPlayer3);

        A = findViewById(R.id.letterAp3);
        B = findViewById(R.id.letterBp3);
        C = findViewById(R.id.letterCp3);
        D = findViewById(R.id.letterDp3);
        E = findViewById(R.id.letterEp3);
        F = findViewById(R.id.letterFp3);
        G = findViewById(R.id.letterGp3);
        H = findViewById(R.id.letterHp3);
        I = findViewById(R.id.letterIp3);
        J = findViewById(R.id.letterJp3);
        K = findViewById(R.id.letterKp3);
        L = findViewById(R.id.letterLp3);
        M = findViewById(R.id.letterMp3);
        N = findViewById(R.id.letterNp3);
        O = findViewById(R.id.letterOp3);
        P = findViewById(R.id.letterPp3);
        letterR = findViewById(R.id.letterRp3);
        S = findViewById(R.id.letterSp3);
        T = findViewById(R.id.letterTp3);
        U = findViewById(R.id.letterUp3);
        V = findViewById(R.id.letterVp3);
        Z = findViewById(R.id.letterZp3);
        Ž = findViewById(R.id.letterŽp3);
        Č = findViewById(R.id.letterČp3);
        Ć = findViewById(R.id.letterĆp3);
        Đ = findViewById(R.id.letterĐp3);
        DŽ = findViewById(R.id.letterDŽp3);
        Š = findViewById(R.id.letterŠp3);
        NJ = findViewById(R.id.letterNJp3);
        LJ = findViewById(R.id.letterLJp3);

        score = findViewById(R.id.Player3WordScore);
        word = findViewById(R.id.UserWordPlayer3);

        clear = findViewById(R.id.Player3ClearBtn);
        calculate = findViewById(R.id.Player3Calculate);
        player1Next = findViewById(R.id.Player1NextBtnp3);
        player2Next = findViewById(R.id.Player2NextBtnp3);
        player4Next = findViewById(R.id.Player4NextBtnp3);

        player3 = findViewById(R.id.Player3);

        endGameBtn = findViewById(R.id.Player3EndGameBtn);

        scoreByPoint = findViewById(R.id.Player3UserInputLetter);

        dataRef = FirebaseDatabase.getInstance().getReference().child("Players").child("Player3");
        scoreRef = FirebaseDatabase.getInstance().getReference().child("Scores").child("Player3");
        wordRef = FirebaseDatabase.getInstance().getReference().child("Words").child("Player3");

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
                player3.setText(snapshot.getValue().toString());
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
                startActivity(new Intent(Player3.this, Player1.class));
            }
        });

        player2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreTotal = scoreGetter + Integer.parseInt(score.getText().toString().trim());
                scoreRef.setValue(String.valueOf(scoreTotal));
                storeWord(Integer.parseInt(score.getText().toString().trim()));
                startActivity(new Intent(Player3.this, Player2.class));
            }
        });

        player4Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreTotal = scoreGetter + Integer.parseInt(score.getText().toString().trim());
                scoreRef.setValue(String.valueOf(scoreTotal));
                storeWord(Integer.parseInt(score.getText().toString().trim()));
                startActivity(new Intent(Player3.this, Player4.class));
            }
        });

        endGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Player3.this, EndGameActivity.class));
            }
        });

    }

    private void storeWord(int addScore) {
        wordRef.push().setValue(word.getText().toString() + " - " + String.valueOf(addScore));
    }
}
