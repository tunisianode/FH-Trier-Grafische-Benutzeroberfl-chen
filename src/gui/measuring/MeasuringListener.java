package gui.measuring;

public interface MeasuringListener
{
    public void valueMeasured(double measureValue, int name);

    public void addMeasuringListener();
}
