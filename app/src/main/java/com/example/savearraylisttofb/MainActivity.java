package com.example.savearraylisttofb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlayer1, btnPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnPlayer1 = findViewById(R.id.Player1);
        btnPlayer2 = findViewById(R.id.Player2);

        btnPlayer1.setOnClickListener(this);
        btnPlayer2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == btnPlayer1)
        {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("Player","Player1");
            startActivity(intent);
        }

        if(v == btnPlayer2)
        {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("Player","Player2");
            startActivity(intent);
        }
    }
}