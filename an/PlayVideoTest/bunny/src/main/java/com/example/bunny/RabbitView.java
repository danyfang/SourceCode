package com.example.bunny;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RabbitView extends View {
    public float bitmapX;
    public float bitmapY;
    public RabbitView(Context context){
        super(context);
        bitmapX = 210;
        bitmapY = 130;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);

        if(!bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
