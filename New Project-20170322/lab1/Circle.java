package lab1;

/*
 	TASK:
	Найти длину окружности L и площадь круга S заданного радиуса R: 
	L = 2•π•R, S = π•R2. 
	В качестве значения π использовать 3.14
*/

public class Circle {
	
	private int Radius = 0;
	private double Pi = Math.PI;
	
	public Circle(int radius)
	{
		Radius = radius;
	}
	
	//S = π•R^2
	public double GetSquare()
	{
		return Pi * Radius * Radius; 
	}
	
	//L = 2•π•R
	public double GetLength()
	{
		return 2 * Pi * Radius;
	}
}
