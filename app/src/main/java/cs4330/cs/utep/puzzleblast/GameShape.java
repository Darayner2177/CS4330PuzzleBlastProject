package cs4330.cs.utep.puzzleblast;

import android.graphics.Canvas;

public interface GameShape {
    public void update(int x, int y);
    public void draw(Canvas canvas);
}
