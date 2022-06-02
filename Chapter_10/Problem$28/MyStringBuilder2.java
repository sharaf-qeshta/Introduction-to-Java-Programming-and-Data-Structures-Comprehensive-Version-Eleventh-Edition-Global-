package chapter_ten;

public class MyStringBuilder2
{
    char[] characters;
    String string;

    public MyStringBuilder2()
    {
        characters = new char[1];
        string = String.valueOf(characters);
    }

    public MyStringBuilder2(String s)
    {
        string = s;
        characters = s.toCharArray();
    }

    public MyStringBuilder2(char[] chars)
    {
        characters = chars;
        string = String.valueOf(chars);
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s)
    {
        char[] newChars = new char[s.length() + string.length()];
        int appendIndex = 0;
        int originalIndex = 0;
        for (int i = 0; i < newChars.length; i++)
        {
            if (i >= offset & appendIndex < s.length())
                newChars[i] = s.characters[appendIndex++];
            else
                newChars[i] = characters[originalIndex++];
        }
        characters = newChars;
        reAssignString();
        return new MyStringBuilder2(string);
    }

    public MyStringBuilder2 reverse()
    {
        string = "";
        for (int i = characters.length-1; i > -1; i--)
            string += characters[i];
        reAssignChars();
        return new MyStringBuilder2(string);
    }

    public int length()
    {
        return string.length();
    }

    public char charAt(int index)
    {
        return characters[index];
    }

    public MyStringBuilder2 toUpperCase()
    {
        for (int i = 0; i < characters.length; i++)
            if (characters[i] > 96 & characters[i] < 123)
                characters[i] -= 32;
        reAssignString();
        return new MyStringBuilder2(string);
    }

    public MyStringBuilder2 substring(int begin)
    {
        String output = "";
        for (int i = begin; i < characters.length; i++)
            output += characters[i];
        return new MyStringBuilder2(output);
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
