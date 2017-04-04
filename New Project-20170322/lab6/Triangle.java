package lab6;

import static java.lang.Math.*;

/**
 * Created by DDshka on 02.04.2017.
 */
public class Triangle extends Figure
{
    private final int QUANTITY_OF_SIDES = 3;

    public Triangle(Point[] points)
    {
        //???
        super(points);
        CheckInput(points);
        //super(points);
    }

    public double[] getSides()
    {
        double[] sides = new double[QUANTITY_OF_SIDES];
        int i = 0;
        while (i != QUANTITY_OF_SIDES)
        {
            if (i < sides.length - 1)
                sides[i] = sqrt(pow(Points[i + 1].x - Points[i].x, 2) + pow(Points[i + 1].y - Points[i].y, 2));
            else
                sides[i] = sqrt(pow(Points[0].x - Points[i].x, 2) + pow(Points[0].y - Points[i].y, 2));
            i++;
        }
        return sides;
    }

    private void CheckInput(Point[] points)
    {
        if (points.length > QUANTITY_OF_SIDES || points.length < QUANTITY_OF_SIDES)
            throw new FigureDoesNotExistException("Triangle exists only with three points");

        if(!isTriangleExists())
            throw new FigureDoesNotExistException("Triangle with such sides does not exist.\n" +
                                                    "Rule:\na + b > c\na + c > b\nb + c > a");
    }

    private boolean isTriangleExists()
    {
        double[] sides = getSides();
        return (sides[0] + sides[1] > sides[2] &&
                sides[0] + sides[2] > sides[1] &&
                sides[1] + sides[2] > sides[0]);
    }
}
