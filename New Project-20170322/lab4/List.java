package lab4;

/*
	TASK:
	Составить описание класса для определения одномерных массивов целых чисел (векторов). 
	Предусмотреть возможность обращения к отдельному элементу массива с контролем выхода за пределы массива, 
	возможность задания произвольных границ индексов при создании объекта, 
	возможность выполнения операций поэлементного сложения и вычитания массивов с одинаковыми границами индексов, 
	умножения и деления всех элементов массива на скаляр, 
	вывода на экран элемента массива по заданному индексу, вывода на экран всего массива. 
	
	Написать программу, демонстрирующую работу с этим классом. 
	Программа должна содержать меню, позволяющее осуществить проверку всех методов класса.
*/

public class List { 
	public enum Operator
	{
		Add,
		Sub,
		Div,
		Mul
	}
	
	private int[] list = null;
	private int count = 0;
	private int size = 0;
	
	public List(int Size)
	{
		list = new int[Size];
		size = Size;
	}
	
	public List(int Size, int initValue)
	{
		list = new int[Size];
		size = Size;
		
		for (; count < size; count++)
			list[count] = initValue;
	}
	
	public void Add(int val)
	{
		CheckSize();
		
		list[count] = val;
		count++;
	}
	
	public int GetElement(int index)
	{
		CheckIndex(index);
		
		return list[index];
	}
	
	public void SetElement(int index, int val)
	{
		CheckIndex(index);
		
		list[index] = val;
	}
	
	public void ScalarOperation(int value, Operator operator)
	{
		for (int index = 0; index < count; index++)
		{
			switch (operator)
			{
				case Add:
					list[index] += 	value;
					break;
				case Sub:
					list[index] -= value;
					break;
				case Mul: 
					list[index] *= value;
					break;
				case Div:
					list[index] /= value;
					break;
			}
		}
	}
	
	public int[] Array()
	{
		int array[] = new int[count];
		for (int index = 0; index < count; index++)
			array[index] = list[index];
		return array;
	}
	
	public int Count()
	{
		return count;
	}
	
	public static void SumLists(List operand1, List operand2)
	{
		handleOperation(operand1, operand2, Operator.Add);
	}
	
	public static void SubLists(List operand1, List operand2)
	{
		handleOperation(operand1, operand2, Operator.Sub);
	}
	
	public static void MulLists(List operand1, List operand2)
	{
		handleOperation(operand1, operand2, Operator.Mul);
	}
	
	public static void DivLists(List operand1, List operand2)
	{
		handleOperation(operand1, operand2, Operator.Div);
	}
	
	private static void handleOperation(List operand1, List operand2, Operator operator)
	{
		CheckListsSizes(operand1, operand2);
		
		int count = operand1.Count();
		for (int index = 0; index < count; index++)
		{
			int result = Integer.MIN_VALUE;
			switch (operator)
			{
				case Add:
					result = operand1.GetElement(index) + operand2.GetElement(index);
					break;			
				case Sub:
					result = operand1.GetElement(index) - operand2.GetElement(index);
					break;
				case Mul:
					result = operand1.GetElement(index) * operand2.GetElement(index);
					break;	
				case Div:
					result = operand1.GetElement(index) / operand2.GetElement(index);
					break;
			}
			operand1.SetElement(index, result);
		}
	}
	
	private void CheckIndex(int index)
	{
		if (!(index >= 0 && index <= count))
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void CheckSize()
	{
		if (count == size) 
			throw new ListIsFullException("List is full. Can`t add new element");
	}
	
	private static void CheckListsSizes(List list1, List list2)
	{
		if (list1.Count() != list2.Count())
			throw new ListSizesDismatchExcaption("Size dismatch between two lists");
	}
	
	private class ListIsFullException extends RuntimeException
	{
		public ListIsFullException() {}
		
		public ListIsFullException(String message)
		{
			super(message);
		}
	}
	
	private static class ListSizesDismatchExcaption extends RuntimeException
	{
		public ListSizesDismatchExcaption() {}
		
		public ListSizesDismatchExcaption(String message)
		{
			super(message);
		}
	}
}
