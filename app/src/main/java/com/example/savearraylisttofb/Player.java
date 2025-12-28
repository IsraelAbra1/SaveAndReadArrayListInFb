package com.example.savearraylisttofb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private Context context;
    public Player(String name)
    {
        this.name=name;
        hand=new ArrayList<Card>();
        this.context=context;

    }
    public void AddCard(Card c )
    {
        hand.add(c);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
