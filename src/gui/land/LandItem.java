package gui.land;

public class LandItem
{
    private String value;
    private String label;

    public LandItem(Land land)
    {
        this.value = land.getName();
        this.label = land.getName();
    }

    public String getValue()
    {
        return this.value;
    }

    public String getLabel()
    {
        return this.label;
    }

    @Override
    public String toString()
    {
        return label;
    }
}