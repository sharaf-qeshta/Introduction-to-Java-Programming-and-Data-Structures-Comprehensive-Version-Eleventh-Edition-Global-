package chapter38;

import java.util.HashMap;
public class Tax
{
    private double income;
    private String status;
    private double tax;
    private int fillingStatus;

    private final HashMap<String, Double[]> map;
    private final double[] rates = {0.1, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};

    public Tax(String status, double income)
    {
        // 2022
        map = new HashMap<>();

        Double[] singleAndMarriedJointly = {10_275.0, 41_775.0, 89_075.0, 170_050.0,
                215_950.0, 539_900.0, 539_901.0};
        map.put("Single", singleAndMarriedJointly);
        map.put("Married Filing Jointly", singleAndMarriedJointly);

        Double[] marriedSeperatleyAndHeadOfHouseHold = {10_275.0, 41_775.0, 89_075.0, 170_050.0,
                215_950.0, 323_925.0, 323_926.0};
        map.put("Married Filing Separately", marriedSeperatleyAndHeadOfHouseHold);
        map.put("Head of Household", marriedSeperatleyAndHeadOfHouseHold);
        map.put("Qualifying Widow(er)", marriedSeperatleyAndHeadOfHouseHold);
        this.status = status;
        this.income = income;
        computeTax();
    }

    public void computeTax()
    {
        int fillingStatus = 0;
        double tax = 0;
        Double[] ranges = map.get(status.trim());


        for (int i = 0; i < 5; i++)
        {
            if (income <= ranges[i])
            {
                tax = rates[i] * income;
                fillingStatus = i;
                break;
            }
        }

        if (income >= ranges[5])
        {
            tax = rates[5] * income;
            fillingStatus = 5;
        }

        this.tax = tax;
        this.fillingStatus = fillingStatus;
    }

    public double getIncome()
    {
        return income;
    }

    public double getTax()
    {
        return tax;
    }

    public int getFillingStatus()
    {
        return fillingStatus;
    }
}
