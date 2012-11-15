package gui.measuring;

import java.util.ArrayList;
import java.util.List;

public class MeasuringCenter
{
    private List<MeasuringListener> listener = new ArrayList<MeasuringListener>();

    public MeasuringCenter()
    {
        // TODO Auto-generated constructor stub
    }

    public void reportMeasuredValue(double measureValue, int name)
    {
        for (MeasuringListener dlistener : listener)
        {
            dlistener.valueMeasured(measureValue, name);
        }
    }

    public void addMeasuringListener(MeasuringListener ml)
    {
        listener.add(ml);
    }
}
