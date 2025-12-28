package com.example.savearraylisttofb;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private ArrayList<Card> deck;   // הקופה בתוך Board
    private Player player1;
    private Player player2;
    private Card openCard;
    private Context context;
    public static String activePlayer;

    public Board(Context context, String activePlayer) {
        this.context = context;
        this.activePlayer = activePlayer;

        deck = new ArrayList<>();

        // יצירת הקלפים (4 עותקים מכל מספר 0-10)
        for (int value = 0; value <= 10; value++) {
            for (int copy = 0; copy < 4; copy++) {
                deck.add(new Card(false,value));
            }
        }

        // ערבוב
        Collections.shuffle(deck);

        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        // חלוקת 5 קלפים לכל שחקן
        for (int i = 0; i < 5; i++) {
            player1.AddCard(deck.remove(0));
            player2.AddCard(deck.remove(0));
        }
        openCard=deck.remove(0);

        FBsingleton.getInstance(context).setPackage(player1.getHand(),"Player1");
        FBsingleton.getInstance(context).setPackage(player2.getHand(),"Player2");

    }

    public void updateCards(ArrayList<Card> arrayList) {
        printHand(arrayList);

    }

    void printHand(ArrayList<Card> arrayList)
    {
        String str="";
        for(int i=0;i<arrayList.size();i++)
        {
            System.out.println(arrayList.get(i).getValue());
            str+=arrayList.get(i).getValue() + " ";

        }
        ((GameActivity)context).PrintHand(str);
    }
}
