package chapter_thirty_three.samples;

import java.net.*;

/**
 * Listing 33.3 IdentifyHostNameIP.java
 * */
public class IdentifyHostNameIP
{
    public static void main(String[] args)
    {
        for (int i = 0; i < args.length; i++)
        {
            try
            {
                InetAddress address = InetAddress.getByName(args[i]);
                System.out.print("Host name: " + address.getHostName() + " ");
                System.out.println("IP address: " + address.getHostAddress());
            }
            catch (UnknownHostException ex)
            {
                System.err.println("Unknown host or IP address " + args[i]);
            }
        }
    }
}
