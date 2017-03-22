import java.util.Scanner;
import lab1.Circle;
import lab3.FileRead;
import lab4.List;


public class main {
	public static void main(String[] args) {
		/* LAB_1
		Circle circle = new Circle(10);
		System.out.println("Square = " + circle.GetSquare());
		System.out.println("Length = " + circle.GetLength());
		*/
		
		/* LAB_2
		double y = Equasion();
		System.out.println("f(x) = " + y);
		*/
		
		/* LAB_3
		FileRead fr = new FileRead("C:\\1.txt");
		System.out.println("Max = " + fr.GetMaxVal());
		System.out.println("Min = " + fr.GetMinVal());
		*/
		
		// LAB_4
		List list = new List(10);
		for (int i = 0; i < 10; i++) {
			list.Add(i);
		}
		System.out.println("9th element = " + list.GetElement(9));
		System.out.println("Total elements = " + list.Count());
		
		list.SetElement(9, 15);
		System.out.println("Edited 9th element = " + list.GetElement(9) + "\n");
		
		list.ScalarOperation(10, List.Operator.Mul);
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "th element = " + list.GetElement(i));
		}
		
		List list1 = new List(10, 10);
		List.SumLists(list, list1);
		System.out.println("\n" + "SUMMED LIST");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "th element = " + list.GetElement(i));
		}
	}

	//LAB_2
	public static double Equasion()
	{
		/*TASK:
			f(x) = (4 - x * ln(x^2 + 1)) / (sqrt(x) + sqrt(10 + x))
			
			test x = 10; 
			output y = -5.5212105727;
		*/
		double x = 0;
		double y = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter X");
		if (scanner.hasNextInt()) 
		{
			x = scanner.nextInt();
			scanner.close();
		}
		else 
		{
			System.out.println("Wrong input\nOne more time\n");	
			Equasion();
		}
		System.out.println("X = " + x);
		
		y = (4 - x * Math.log(x * x + 1)) / (Math.sqrt(x) + Math.sqrt(10 + x));
		
		return y;
	}
}
