package com.example.savearraylisttofb;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

// google explanations
// https://firebase.google.com/docs/database/android/lists-of-data#java_1


public class FBsingleton {
    private static FBsingleton instance;
    private static Context context;

    FirebaseDatabase database;

    private FBsingleton() {
        database = FirebaseDatabase.getInstance();

        // read the records from the Firebase and order them by the record from highest to lowest
        // limit to only 8 items
        //Query myQuery = database.getReference("records").orderByChild("score").limitToLast(10);
        DatabaseReference myRef = database.getReference("YanivGame/" + Board.activePlayer + "/");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                if(snapshot != null)
                {
                    ArrayList<Card> arrayList = new ArrayList<>();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Card card = dataSnapshot.getValue(Card.class);
                        arrayList.add(card);
                    };
                    ((GameActivity)context).updateCards(arrayList);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }

    public static FBsingleton getInstance(Context context1) {
        context = context1;
        if (null == instance) {
            instance = new FBsingleton();
        }
        return instance;
    }

    public void setCard(Card card, String packageName)
    {
        // Write a message to the database
        //DatabaseReference myRef = database.getReference("records").push(); // push adds new node with unique value

        DatabaseReference myRef = database.getReference("YanivGame/" + packageName + "/");

        myRef.setValue(card);
    }

    public void setPackage(ArrayList<Card> cards, String packageName)
    {
        // Write a message to the database
        //DatabaseReference myRef = database.getReference("records").push(); // push adds new node with unique value

        DatabaseReference myRef = database.getReference("YanivGame/" + packageName + "/");
        myRef.setValue(cards);
    }
}
