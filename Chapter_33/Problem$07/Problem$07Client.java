package chapter_thirty_three;


import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Arrays;

public class Problem$07Client
{
    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 8_000);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            long[] last100Primes = (long[]) inputStream.readObject();
            System.out.println(Arrays.toString(last100Primes));
            System.out.println(last100Primes.length);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
