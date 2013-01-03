package gui.composite;

/**
 * Abstrakte Basisklasse aller Elemente. Aus dieser Klasse werden
 * PrimitiveElement und Container abgeleitet.
 * 
 * @author Rainer Oechsle
 */
public abstract class Component
{
    /**
     * Referenz auf den Container, in der das jeweilige Element enthalten ist
     * ("Erster" Vorfahre).
     */
    protected Container pred;
    protected String name;
    protected int weight;

    /**
     * Konstruktor.
     * 
     * @param name
     *            Name
     * @param weight
     *            Gewicht
     */
    public Component(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Liefert den Vorg�nger des Objekts.
     * 
     * @return Vorg�nger
     */
    public Container getPredecessor()
    {
        return pred;
    }

    /**
     * Setzt den Namen f�r dieses Objekt.
     * 
     * @param name
     *            neuer Name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Liefert den Namen dieses Objekts.
     * 
     * @return Name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setzt das Gewicht f�r dieses Objekt.
     * 
     * @param weight
     */
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    /**
     * Liefert das Gewicht dieses Objekts.
     * 
     * @return int
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Methode toString.
     * 
     * @return String-Darstellung
     */
    public String toString()
    {
        return name;
        /*
         * String result = name + " (weight: " + weight + "), "; if (pred !=
         * null) { result += "contained in " + pred.getName(); } else { result
         * += "ROOT"; } return result;
         */
    }

    /**
     * Gibt das Objekt aus.
     * 
     * @param indentation
     *            Anzahl der einger�ckten Zeichen
     */
    protected void print(int indentation)
    {
        for (int i = 0; i < indentation; i++)
        {
            System.out.print(" ");
        }
        System.out.println(this);
    }

    /**
     * Gibt das Objekt aus.
     */
    public void print()
    {
        print(0);
    }
}