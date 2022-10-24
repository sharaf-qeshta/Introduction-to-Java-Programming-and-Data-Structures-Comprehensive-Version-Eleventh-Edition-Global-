package chapter_thirty_three;

import java.io.File;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

public class Problem$07Server
{
    private static final String FILE_PATH = "src/chapter_thirty_three/PrimeNumbers.dat";

    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(8_000);
            while (true)
            {
                Socket socket = serverSocket.accept();
                Runnable runnable = () ->
                {
                    try
                    {
                        ObjectOutputStream outputStream = new
                                ObjectOutputStream(socket.getOutputStream());
                        long[] primes = getPrimes(100);
                        outputStream.writeObject(primes);
                        outputStream.flush();
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        System.exit(-1);
                    }
                };

                new Thread(runnable).start();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }
    }

    public static long[] getPrimes(int bound)
    {
        long[] primes = new long[bound];
        int index = 0;
        int limit = 8*bound;
        int currentLimit = 8;
        long fileLength = new File(FILE_PATH).length();
        try (RandomAccessFile reader = new RandomAccessFile(FILE_PATH, "r"))
        {
            for (int i = currentLimit; i <= limit; i+=8)
            {
                reader.seek(fileLength - i);
                primes[index++] = reader.readLong();
            }
        }
        catch (Exception ignored) { }

        return primes;
    }
}
