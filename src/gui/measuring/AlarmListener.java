package gui.measuring;

public class AlarmListener implements MeasuringListener
{
    private double min, max;

    public AlarmListener(double min, double max)
    {
        this.min = min;
        this.max = max;
    }

    @Override
    public void valueMeasured(double measureValue, int name)
    {
        if (measureValue > this.max || measureValue < this.min)
        {
            System.out.println("GerŠt " + name + " meldet Messwert "
                    + measureValue + ", der au§erhalb des Intervalls ["
                    + this.min + ", " + this.max + "] liegt.");
        }
    }

    @Override
    public void addMeasuringListener()
    {
        // TODO Auto-generated method stub

    }

}
