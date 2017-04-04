package lab6;

/**
 * Created by DDshka on 02.04.2017.
 */
public class Point implements Cloneable
{
    public int x;
    public int y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone()
    {
        try {
            return (Point) super.clone();
        }
        catch( CloneNotSupportedException ex ) {
            throw new InternalError();
        }
    }
}
