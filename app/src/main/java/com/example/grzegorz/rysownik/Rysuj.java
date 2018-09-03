package com.example.grzegorz.rysownik;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Rysuj extends View {

    private Bitmap rBitmap;
    private Canvas rCanvas;
    private Path rPath;
    private Paint rPaint, r2Paint;
    private float rX, rY;

    public String getRozmiarCzcionki() {
        return String.valueOf(rozmiarCzcionki);
    }

    private float rozmiarCzcionki = 10;
    Context context;

    public Rysuj(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        rPath = new Path();
        rPaint = new Paint();
        rPaint.setAntiAlias(true);
        rPaint.setColor(Color.BLACK);
        rPaint.setStyle(Paint.Style.STROKE);
        rPaint.setStrokeJoin(Paint.Join.ROUND);
        rPaint.setStrokeWidth(rozmiarCzcionki);
        r2Paint = new Paint(Paint.DITHER_FLAG);

    }

    private void startRysowania(float _x, float _y) {
        for (int i = 0; i <= rozmiarCzcionki + 10; i++) {
            rCanvas.drawCircle(_x, _y, i, rPaint);
        }
        rCanvas.drawCircle(_x, _y, rozmiarCzcionki + 10, rPaint);
        rPath.moveTo(_x, _y);
        rX = _x;
        rY = _y;
    }

    private void rysujeRysowania(float _x, float _y) {
        rPath.lineTo(_x, _y);
    }

    private void konczenieRysowania(float _x, float _y) {
        //  rPath.lineTo(_x, _y);
        for (int i = 0; i <= rozmiarCzcionki + 10; i++) {
            rCanvas.drawCircle(_x, _y, i, rPaint);
        }
        rCanvas.drawCircle(_x, _y, rozmiarCzcionki + 10, rPaint);

    }

    public void kasujNarysowanie() {
        //  rPaint.setColor(Color.BLACK);
        rCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public void czerwonyRysuj() {
        rPaint.setColor(Color.RED);
        invalidate();
    }

    public void czarnyRysuj() {
        rPaint.setColor(Color.BLACK);
        invalidate();
    }

    public void niebieskiRysuj() {
        rPaint.setColor(Color.BLUE);
        invalidate();
    }

    public void zielonyRysuj() {
        rPaint.setColor(Color.GREEN);
        invalidate();
    }

    public void zoltyRysuj() {
        rPaint.setColor(Color.rgb(255, 140, 0));
        invalidate();
    }

    public void zmniejszRysuj() {
        if (rozmiarCzcionki > 1) {
            --rozmiarCzcionki;
            rPaint.setStrokeWidth(rozmiarCzcionki);
//           Toast.makeText(Rysuj.this,"Zmniejszenie czcionki" + String.valueOf(rozmiarCzcionki),Toast.LENGTH_SHORT).show();
        }
    }

    public void zwiekszRysuj() {
        if (rozmiarCzcionki < 40) {
            ++rozmiarCzcionki;
            rPaint.setStrokeWidth(rozmiarCzcionki);
//           Toast.makeText(Rysuj.this,"Zmniejszenie czcionki" + String.valueOf(rozmiarCzcionki),Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(rBitmap, 0, 0, r2Paint);
        canvas.drawPath(rPath, rPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        rBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        rCanvas = new Canvas(rBitmap);
    }

    @Override
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startRysowania(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                rysujeRysowania(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                konczenieRysowania(x, y);
                rCanvas.drawPath(rPath, rPaint);
                invalidate();
                rPath.reset();

                break;
        }
        return true;

    }
}

