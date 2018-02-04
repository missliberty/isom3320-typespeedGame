public class StartingLine {
	
private int screenWidth;
private int screenHeight;
private int xStartPosition;
private int yStartPosition;
private int xEndPosition;
private int yEndPosition;
private int width = 50;
private int tv1y = 0;
private int tv2y = 0;
private int tv3y = 0;
private Paint paint;


public StartingLine(Context context, int screenX, int screenY, int laneCount) {
    screenWidth = screenX;
    screenHeight = screenY;
    this.xStartPosition = screenWidth - width - (screenHeight / laneCount) * 2;
    this.yStartPosition = 0;
    this.xEndPosition = screenWidth - width - (screenHeight / laneCount) * 2;
    this.yEndPosition = screenHeight;
    paint = new Paint();
}

public void update(int color) {
    paint.setColor(color);
    paint.setStrokeWidth(2);
    paint.setTextSize(30);
    paint.setTextAlign(Paint.Align.CENTER);
}

public void draw(Canvas canvas) {
    Rect tb = new Rect();
    paint.getTextBounds("STOP AFTER THIS POINT", 0, "STOP AFTER THIS POINT".length(), tb);
    if (tv1y == 0 && tv2y == 0 && tv3y == 0) {
        tv1y = 0;
        tv2y = tb.width() + width;//tb.width()+width = gap between two texts
        tv3y = 2 * (tb.width() + width);
    } else {
        if (tv3y  >= (3 * (tb.width() + width))) {
            tv3y = 2 * (tb.width() + width);
        }

        tv1y = tv3y - 2 * (width + tb.width());
        tv2y = tv1y + width + tb.width();
        tv3y = tv2y + width + tb.width();
    }

    canvas.drawLine(xStartPosition, yStartPosition, xEndPosition, yEndPosition, paint);
    canvas.drawLine(xStartPosition + width, yStartPosition, xEndPosition + width, yEndPosition, paint);
    canvas.save();
    canvas.rotate(270, screenWidth / 2, screenHeight / 2);

    canvas.drawText("STOP AFTER THIS POINT", tv1y += 5, yEndPosition - 20, paint);
    canvas.drawText("STOP AFTER THIS POINT", tv2y += 5, yEndPosition - 20, paint);
    canvas.drawText("STOP AFTER THIS POINT", tv3y += 5, yEndPosition - 20, paint);
    canvas.restore();
}
}