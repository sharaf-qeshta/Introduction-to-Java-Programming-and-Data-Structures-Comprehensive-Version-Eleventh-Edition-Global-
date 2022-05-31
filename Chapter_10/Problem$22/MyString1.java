package chapter_ten;

public class MyString1
{
    char[] str;

    public MyString1(char[] str)
    {
        this.str = str;
    }

    public char charAt(int index)
    {
        return str[index];
    }

    public int length()
    {
        return str.length;
    }

    public MyString1 substring(int begin, int end)
    {
        char[] sub = new char[end - begin];

        for (int i = begin; i < end; i++)
            sub[i] = str[i];

        return new MyString1(sub);
    }

    public MyString1 toLowerCase()
    {
        for (int i = 0; i < str.length;i++)
            if (str[i] > 64 && str[i] < 97)
                str[i] += 32;
        return this;
    }



    public boolean equals(MyString1 s)
    {
        if (s.length() != length())
            return false;

        for (int i = 0; i < str.length;i++)
            if (str[i] != s.str[i])
                return false;
        return true;
    }


    public static MyString1 valueOf(int i)
    {
        char[] chars = new char[getLength(i)];
        int index = 0;
        while (Math.abs(i) > 0)
        {
            int character = i % 10;
            i /= 10;
            chars[index++] = (char) (character + 48);
        }

        int k = 0;
        char[] temp = chars.clone();
        for (int j = chars.length-1; j > -1;j--,k++)
            chars[k] = temp[j];

        return new MyString1(chars);
    }

    private static int getLength(int i)
    {
        int length = 0;
        while (Math.abs(i) > 0)
        {
            length++;
            i /= 10;
        }
        return length;
    }


    public char[] getStr()
    {
        return str;
    }
}
