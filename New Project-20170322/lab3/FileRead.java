package lab3;

import java.io.*;

/*
 	TASK:
 	Задан файл целых чисел. 
 	Указать диапазон, в котором находятся его элементы.
*/
public class FileRead {
	
	private File file = null;
	private int MaxVal = Integer.MIN_VALUE;
	private int MinVal = Integer.MAX_VALUE;
	
	public FileRead(String path)
	{
		file = new File(path);
		GetRange();
	}
	
	public int GetMaxVal()
	{
		return MaxVal;
	}
	
	public int GetMinVal()
	{
		return MinVal;
	}
	
	private void GetRange()
	{
		try (FileReader reader = new FileReader(file))
		{
			String text = "";
			int char_code = -1;
			do 
			{
				char_code = reader.read();
				char ch = (char)char_code;
				if (Character.isDigit(ch) || ch == '+' || ch == '-')
					text += ch; 
				else if (text != "")
				{
					int number = Integer.parseInt(text);
					text = "";
					
					CompareMaxMin(number);
				}
			} while (char_code != -1);
		}
		catch (IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			//reader.close();
		}
	}
	
	private void CompareMaxMin(int number)
	{
		MaxVal = (MaxVal < number) ? number : MaxVal;
		MinVal = (MinVal > number) ? number : MinVal;
	}
}
