import java.util.Scanner;
import lab6.*;


public class main
{
	public static void main(String[] args)
	{
		Point[] points = new Point[3];
		points[0] = new Point(0,0);
		points[1] = new Point(0,5);
		points[2] = new Point(5,0);
		Triangle triforce = new Triangle(points);

		points = new Point[3];
		points[0] = new Point(0,0);
		points[1] = new Point(0,3);
		points[2] = new Point(3,0);
		Triangle triforce2 = new Triangle(points);

		System.out.println(triforce.isInclude(triforce2));
		triforce.move(new Point(5, 5));
		double a[] = triforce.getSides();
		for (int i =0; i < 3; i++)
			System.out.println(a[i]);


		points = triforce.getPoints();
		for (int i = 0; i < points.length; i++)
		{
			System.out.println(points[i].x + " " + points[i].y);
		}

		points = new Point[4];
		points[0] = new Point(0,0);
		points[1] = new Point(0,3);
		points[2] = new Point(3,3);
		points[3] = new Point(3,0);
		Tetragon t = new Tetragon(points);
		a = t.getSides();
		for (int i =0; i < 4; i++)
			System.out.println(a[i]);
	}
}
