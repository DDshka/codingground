package lab5;

import lab5.Str;

/**
 * Created by DDshka on 28.03.2017.
 */
public class DecString extends Str
{
    public DecString(String string)
    {
        CheckInput(string);
        str = string;
    }

    public DecString(String string, boolean findSub)
    {
        if (findSub)
        {
            str = CheckInputWithSearch(string);
        }
        else
        {
            CheckInput(string);
            str = string;
        }
    }

    private String CheckInputWithSearch(String string)
    {
        String str = "";
        for (int i = 0; i < string.length(); i++)
        {
            if (Character.isDigit(string.charAt(i)))
            {
                str += string.charAt(i);
            }
        }
        return str;
    }

    private void CheckInput(String string)
    {
        for (int i = 0; i < string.length(); i++)
        {
            if (!Character.isDigit(string.charAt(i)))
            {
                throw new InvalidDecimalString();
            }
        }
    }

    private static class InvalidDecimalString extends RuntimeException
    {
        public InvalidDecimalString() {}

        public InvalidDecimalString(String message)
        {
            super(message);
        }
    }
}
