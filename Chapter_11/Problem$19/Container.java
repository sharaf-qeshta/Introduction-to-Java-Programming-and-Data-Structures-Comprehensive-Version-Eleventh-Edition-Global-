package chapter_eleven;

import java.util.ArrayList;

public class Container
{
    public final int MAX_WEIGHT = 10;
    public static int numberOfObjects = 0;
    private double actualWeight = 0;
    private ArrayList<Double> weights = new ArrayList<>();

    public void startFilling(ArrayList<Double> weights)
    {
        double weight = weights.get(0);

        while (actualWeight+weight <= MAX_WEIGHT)
        {
            this.weights.add(weight);
            actualWeight += weight;
            weights.remove(0);
            numberOfObjects++;
            if (weights.isEmpty())
                break;
            weight = weights.get(0);
        }
    }

    public ArrayList<Double> getWeights()
    {
        return weights;
    }
}
