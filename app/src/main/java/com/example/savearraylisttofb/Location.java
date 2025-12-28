package com.example.savearraylisttofb;

import android.graphics.Canvas;

public abstract class Location {
    protected int x,y;
    public Location(int x, int y){
        this.x=x;
        this.y=y;
    }

    public abstract void Draw(Canvas canvas);
}
