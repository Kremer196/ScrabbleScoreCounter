package com.example.scrabblescorecounter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class Player4Words extends AppCompatActivity {

    private TextView words;

    private DatabaseReference player4WordRef;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player4_words);

        words = findViewById(R.id.Player4WordList);
        player4WordRef = FirebaseDatabase.getInstance().getReference().child("Words").child("Player4");

        player4WordRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                displayWords(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void displayWords(DataSnapshot snapshot) {
        Iterator it = snapshot.getChildren().iterator();

        while(it.hasNext()) {
            words.append((String) ((DataSnapshot)it.next()).getValue().toString() + "\n");
        }
    }
}
