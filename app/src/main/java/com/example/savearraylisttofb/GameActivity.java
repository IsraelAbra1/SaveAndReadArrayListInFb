package com.example.savearraylisttofb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private Board board;
    private String player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent= getIntent();
        player = intent.getStringExtra("Player");


        board = new Board(this, player);
    }


    public void updateCards(ArrayList<Card> arrayList) {
        board.updateCards(arrayList);

    }

    public void PrintHand(String str) {
        TextView tv = findViewById(R.id.tv);
        tv.setText(str);

    }
}