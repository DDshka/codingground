package lab6;

import static java.lang.Math.*;

/**
 * Created by DDshka on 02.04.2017.
 */
public abstract class Figure
{
    protected Point Points[];

    public Figure() {};

    /**
     * @param points
     */
    public Figure(Point[] points)
    {
        Points = points;
    }

    public Point[] getPoints()
    {
        return Points;
    }

    /**Moves first point in point array of figure
     * to entered point and shift all another points
     * @param toPoint
     */
    public void move(Point toPoint)
    {
        for (Point thisPoint : Points)
        {
            thisPoint.x += toPoint.x;
            thisPoint.y += toPoint.y;
        }
    }

    public boolean isInclude(Figure figure)
    {
        Point thisMax = max(this.Points);
        Point thisMin = min(this.Points);

        Point anotherMax = max(figure.getPoints());
        Point anotherMin = min(figure.getPoints());

        if ((anotherMax.x > thisMax.x && anotherMax.y > thisMax.y) ||
            (anotherMin.x < thisMin.x && anotherMin.y < thisMax.y))
                return false;

        return true;
    }

    /**Something like equlas, but "better"
     * @param figure
     * @return true if figures are equal in coordinates
     */
    public boolean compare(Figure figure)
    {
        if (this.Points.length != figure.getPoints().length)
            return false;

        for (Point thisPoint : this.Points)
        {
            boolean isFound = false;
            for (Point anotherPoint : figure.getPoints())
            {
                if (thisPoint.x == anotherPoint.x &&
                    thisPoint.y == anotherPoint.y)
                    isFound = true;
            }
            if (!isFound)
                return false;
        }
        return true;
    }

    /**
     * @param points
     * @return Point where X - Max x ocoordinate of figure and same for Y
     */
    private Point max(Point points[])
    {
        Point maximum = (Point) points[0].clone();
        for (Point point : points)
        {
            if (point.x > maximum.x)
                maximum.x = point.x;
            if (point.y > maximum.y)
                maximum.y = point.y;
        }
        return maximum;
    }

    private Point min(Point points[])
    {
        Point minimum = (Point) points[0].clone();
        for (Point point : points)
        {
            if (minimum.x > point.x)
                minimum.x = point.x;
            if (minimum.y > point.y)
                minimum.y = point.y;
        }
        return minimum;
    }

    protected class FigureDoesNotExistException extends RuntimeException
    {
        public FigureDoesNotExistException() {}

        public FigureDoesNotExistException(String message)
        {
            super(message);
        }
    }
}
