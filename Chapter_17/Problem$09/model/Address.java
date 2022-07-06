package chapter_seventeen.model;

import java.io.Serializable;

public class Address implements Serializable
{
    private String name, street, city, state, zip;

    public Address(String name, String street,
                   String city, String state, String zip)
    {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }


    @Override
    public boolean equals(Object obj)
    {
        try
        {
            Address address = (Address) obj;
            return getID().equals(address.getID());
        }
        catch (Exception e)
        {
            return false;
        }
    }


    public String getID()
    {
        return name+street+city+city+state+zip; // this the id
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }
}
