package chapter_thirty_three;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Problem$06Server
{
    private static final String FILE_NAME = "student.dat";
    private static ObjectOutputStream outputToAFile;

    public static void main(String[] args)
    {
            try
            {
                outputToAFile = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true));

                ServerSocket serverSocket = new ServerSocket(8_000);
                Thread[] concurrentClients = new Thread[2];
                while (true)
                {
                    Socket socket = serverSocket.accept();
                    ClientHandler handler = new ClientHandler(socket);
                    Thread thread = new Thread(handler);
                    if (concurrentClients[0] == null)
                    {
                        concurrentClients[0] = thread;
                        thread.start();
                    }
                    else if (concurrentClients[1] == null)
                    {
                        concurrentClients[1] = thread;
                        thread.start();
                    }
                    else if (!concurrentClients[0].isAlive())
                    {
                        concurrentClients[0] = thread;
                        thread.start();
                    }
                    else if (!concurrentClients[1].isAlive())
                    {
                        concurrentClients[1] = thread;
                        thread.start();
                    }
                    else
                        System.out.println("clients cannot exceed 2");
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
    }


    public static ArrayList<StudentAddress> getAllStudents()
    {
        ArrayList<StudentAddress> students = new ArrayList<>();
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(FILE_NAME)))
            {
                while (true)
                    students.add((StudentAddress) stream.readObject());
            }
            catch (EOFException ignored){ }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        return students;
    }


    public static void add(StudentAddress address)
    {
        try
        {
            outputToAFile.writeObject(address);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }
    }

    private static class ClientHandler implements Runnable
    {
        private ObjectOutputStream toClient;
        private ObjectInputStream fromClient;

        public ClientHandler(Socket socket)
        {
            try
            {
                toClient = new ObjectOutputStream(socket.getOutputStream());
                fromClient = new ObjectInputStream(socket.getInputStream());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }

        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    StudentAddress address = (StudentAddress) fromClient.readObject();
                    add(address);
                    toClient.writeObject(getAllStudents());
                    toClient.flush();
                }
            }
            catch (SocketException exception)
            {
                // client leave
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
