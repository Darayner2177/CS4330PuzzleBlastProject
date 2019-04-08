package cs4330.cs.utep.puzzleblast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread thread;
    private RectangleShape rectangleShape;
    private int x, y;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);

        thread = new GameThread(getHolder(), this);

        rectangleShape = new RectangleShape(new Rect(100,100,200,200), Color.rgb(255,0,0));

        x = 150;
        y = 150;

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean notJoined = true;
        while (notJoined) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notJoined = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                x = (int) event.getX();
                y = (int) event.getY();
         }
        return true;
    }


    public void update() {
        rectangleShape.update(x, y);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (canvas == null){

        }

        canvas.drawColor(Color.WHITE);

        rectangleShape.draw(canvas);
    }
}
