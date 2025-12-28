package com.example.savearraylisttofb;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Card
{
    private int x,y;
    private int value;
    private boolean isopen;

    public Card() {
    }

    public Card(boolean isopen, int value) {
        this.x = 0;
        this.y = 0;
        this.value = value;
        this.isopen = isopen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isIsopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }
}
