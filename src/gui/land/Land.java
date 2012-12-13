package gui.land;

public class Land
{
    private String name;
    private String hauptstadt;
    private long einwohner;
    private long flaeche;

    public Land(String name, String hauptstadt, long einwohner, long flaeche)
    {
        this.name = name;
        this.hauptstadt = hauptstadt;
        this.einwohner = einwohner;
        this.flaeche = flaeche;
    }

    public String getName()
    {
        return name;
    }

    public String getHauptstadt()
    {
        return hauptstadt;
    }

    public long getEinwohner()
    {
        return einwohner;
    }

    public long getFlaeche()
    {

        return flaeche;
    }

    /**
     * Gibt der JComboBox die richtigen Namen zum anzeigen.
     */
    public String toString()
    {
        return this.getName();
    }
}