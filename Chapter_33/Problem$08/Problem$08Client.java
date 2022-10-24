package chapter_thirty_three;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Problem$08Client
{
    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 8_000);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            ArrayList<Long> last100Primes = (ArrayList<Long>) inputStream.readObject();
            System.out.println(last100Primes);
            System.out.println(last100Primes.size());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
