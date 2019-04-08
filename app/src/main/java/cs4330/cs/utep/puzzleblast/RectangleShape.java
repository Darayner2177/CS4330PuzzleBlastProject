package cs4330.cs.utep.puzzleblast;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class RectangleShape implements GameShape {

    private Rect rectangle;
    private int x, y;
    private int color;
    private boolean hasChangedFlag;

    public RectangleShape(Rect rectangle, int color){
        this.rectangle = rectangle;
        this.color = color;
    }

    @Override
    public void update(int x, int y) {
        rectangle.set(x - rectangle.width()/2, y - rectangle.height()/2, x + rectangle.width()/2, y + rectangle.height()/2);

    }

    @Override
    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }
}
