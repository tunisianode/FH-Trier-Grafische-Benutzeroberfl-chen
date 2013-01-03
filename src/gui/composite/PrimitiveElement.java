package gui.composite;

public/**
 * Klasse für primitive Elemente.
 * 
 * @author Rainer Oechsle
 */
class PrimitiveElement extends Component
{
    private String description;

    /**
     * Konstruktor.
     * 
     * @param name
     *            Name
     * @param weight
     *            Gewicht
     * @param description
     *            Beschreibung
     */
    public PrimitiveElement(String name, int weight, String description)
    {
        super(name, weight);
        this.description = description;
    }

    /**
     * Setzt die Beschreibung für dieses Objekt.
     * 
     * @param description
     *            neue Beschreibung
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Liefert die Beschreibung dieses Objekts.
     * 
     * @return Beschreibung
     */
    public String getDescription()
    {
        return description;
    }
}