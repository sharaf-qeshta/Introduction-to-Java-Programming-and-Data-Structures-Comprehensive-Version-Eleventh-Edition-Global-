package chapter_ten;

public class MyString2
{
    private String str;

    public MyString2(String s)
    {
        this.str = s;
    }

    public int compare(String s)
    {
        char[] chars1 = toChars();
        char[] chars2 = toChars(s);

        for(int i = 0; i < chars1.length & i < chars2.length;i++)
        {
            if (chars1[i] < chars2[i])
                return -1; // less than
            if (chars1[i] > chars2[i])
                return 1; // greater than
        }
        return 0; // equal
    }


    public MyString2 substring(int begin)
    {
        char[] chars = new char[str.length() - begin];
        for (int i = 0; i < chars.length & begin < str.length();)
            chars[i++] = str.charAt(begin++);
        return new MyString2(getString(chars));
    }


    public MyString2 toUpperCase()
    {
        char[] chars = toChars();
        for (int i = 0; i < chars.length;i++)
        {
            if (chars[i] > 96 & chars[i] < 123)
                chars[i] -= 32;
        }
        return new MyString2(getString(chars));
    }

    public char[] toChars()
    {
        char[] out = new char[str.length()];
        for (int i = 0; i < str.length();i++)
            out[i] = str.charAt(i);
        return out;
    }

    public static MyString2 valueOf(boolean b)
    {
        if (b)
            return new MyString2("true");
        return new MyString2("false");
    }

    public char[] toChars(String s)
    {
        char[] out = new char[s.length()];
        for (int i = 0; i < s.length();i++)
            out[i] = s.charAt(i);
        return out;
    }


    private String getString(char[] chars)
    {
        String out = "";
        for (int i = 0; i < chars.length;i++)
            out += chars[i];
        return out;
    }

    public String getStr()
    {
        return str;
    }
}
