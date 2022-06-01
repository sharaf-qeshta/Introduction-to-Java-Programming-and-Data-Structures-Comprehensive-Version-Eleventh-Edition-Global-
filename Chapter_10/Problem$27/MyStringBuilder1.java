package chapter_ten;

public class MyStringBuilder1
{
    char[] characters;
    String string;

    public MyStringBuilder1(String s)
    {
        string = s;
        characters = s.toCharArray();
    }

    public MyStringBuilder1 append(MyStringBuilder1 s)
    {
        string += s.string;
        reAssignChars();
        return new MyStringBuilder1(string);
    }

    public MyStringBuilder1 append(int i)
    {
        string += i;
        reAssignChars();
        return new MyStringBuilder1(string);
    }

    public int length()
    {
        return string.length();
    }

    public char charAt(int index)
    {
        return characters[index];
    }

    public MyStringBuilder1 toLowerCase()
    {
        for (int i = 0; i < characters.length; i++)
            if (characters[i] > 64 & characters[i] < 91)
                characters[i] += 32;
        reAssignString();
        return new MyStringBuilder1(string);
    }

    public MyStringBuilder1 substring(int begin, int end)
    {
       String output = "";
        for (int i = begin; i < end;i++)
            output += characters[i];
        return new MyStringBuilder1(output);
    }

    private void reAssignChars()
    {
        characters = string.toCharArray();
    }

    private void reAssignString()
    {
        string = String.valueOf(characters);
    }

    @Override
    public String toString()
    {
        return string;
    }
}
