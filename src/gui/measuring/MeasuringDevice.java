package gui.measuring;

public class MeasuringDevice
{
    private MeasuringCenter mc;
    private int name;

    public MeasuringDevice(MeasuringCenter mc, int name)
    {
        this.mc = mc;
        this.name = name;
    }

    public void measure(double value)
    {
        mc.reportMeasuredValue(value, this.name);
        // mc.reportMeasuredValue(myRandom(0, 100), this.name);
    }

    public static double myRandom(double low, double high)
    {
        return Math.random() * (high - low) + low;
    }
}
