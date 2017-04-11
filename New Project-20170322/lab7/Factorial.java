package lab7;

/**
 * Created by DDshka on 11.04.2017.
 */
public class Factorial
{
    public static long get(short x)
    {
        if (x < 1) return 0;
        long result = 1;
        for (int i = 1; i < x; i++) result *= i;
        return result;
    }
}
