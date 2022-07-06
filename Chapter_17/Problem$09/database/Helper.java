package chapter_seventeen.database;

import chapter_seventeen.model.Address;
import java.io.*;
import java.util.ArrayList;

public class Helper
{
    public static ArrayList<Address> addresses = getAllRows();

    /** get all rows in the db*/
    public static ArrayList<Address> getAllRows()
    {
        ArrayList<Address> addresses = new ArrayList<>();
        try (RandomAccessFile binaryFile = new RandomAccessFile
                ("src/chapter_seventeen/database/db.dat", "r"))
        {
            while (true)
            {
                Address address = new Address(binaryFile.readUTF(), binaryFile.readUTF(),
                        binaryFile.readUTF(), binaryFile.readUTF(), binaryFile.readUTF());
                addresses.add(address);
            }
        }
        catch (EOFException ignored) { }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return addresses;
    }


    public static void updateDB()
    {
        clear();
        try (RandomAccessFile binaryFile = new RandomAccessFile
                ("src/chapter_seventeen/database/db.dat", "rw"))
        {
            for (Address x: addresses)
            {
                binaryFile.writeUTF(x.getName());
                binaryFile.writeUTF(x.getStreet());
                binaryFile.writeUTF(x.getCity());
                binaryFile.writeUTF(x.getState());
                binaryFile.writeUTF(x.getZip());
            }
        }
        catch (EOFException ignored) { }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private static void clear()
    {
        try (ObjectOutputStream binaryFile = new ObjectOutputStream
                (new FileOutputStream("src/chapter_seventeen/database/db.dat")))
        {
           binaryFile.reset();
        }
        catch (EOFException e)
        {
            System.out.println();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static boolean add(Address address)
    {
        if (!addresses.contains(address))
        {
            addresses.add(address);
            updateDB();
            return true;
        }
        return false;
    }

    public static boolean delete(Address address)
    {
        if (addresses.remove(address))
        {
            updateDB();
            return true;
        }
        return false;
    }

    public static boolean update(Address oldAddress, Address newAddress)
    {
        if (addresses.contains(oldAddress))
        {
            addresses.set(addresses.indexOf(oldAddress), newAddress);
            updateDB();
            return true;
        }
        return false;
    }
}
