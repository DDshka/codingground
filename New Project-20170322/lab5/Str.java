package lab5;

/**
 * Created by DDshka on 28.03.2017.
 */
public abstract class Str
{
    protected String str = null;

    public Str() {}

    public Str(String string)
    {
        this.str = string;
    }

    public void Add(String string)
    {
        this.str += string;
    }

    public String Sub(String string)
    {
        if (str.contains(string))
        {
            return (str = str.replace(string, ""));
        }
        return string;
    }

    public String Get()
    {
        return str;
    }
}
