package lab7;

import lab6.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DDshka on 11.04.2017.
 */
public class SaddlePoint
{
    public static List<Point> getPoints(int[][] matrix)
    {
        List<Point> res = new ArrayList<Point>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (isSaddle(matrix, i, j))
                    res.add(new Point(i, j));

        return res;
    }

    private static int getMax(int[] row)
    {
        int max = row[0];
        for (int i = 0; i < row.length; i++)
            if (max < row[i])
                max = row[i];
        return max;
    }

    private static int getMin(int[] row)
    {
        int min = row[0];
        for (int i = 0; i < row.length; i++)
            if (min > row[i])
                min = row[i];
        return min;
    }

    private static int[] getCol(int[][] matrix, int colIndex)
    {
        int[] result = new int[matrix[colIndex].length];
        for (int i = 0; i < matrix[colIndex].length; i++)
            result[i] = matrix[colIndex][i];
        return result;
    }

    private static boolean isSaddle(int[][] matrix, int i, int j)
    {
        int[] col = getCol(matrix, j);
        return (matrix[i][j] == getMax(matrix[i])
                && matrix[i][j] == getMin(col))
                || (matrix[i][j] == getMin(matrix[i])
                && matrix[i][j] == getMax(col));
    }
}
