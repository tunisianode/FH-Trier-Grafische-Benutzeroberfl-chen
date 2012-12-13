package gui.mvc.plusminus;

import java.util.ArrayList;
import java.util.List;

/**
 * Modellkomponente
 */
public class PlusMinusModel
{
    private int count, min, max, step;
    private List<IPlusMinusListener> listener = new ArrayList<IPlusMinusListener>();

    /**
     * Initialisiert ein neues PlusMinusModel-Objekt mit dem Minimum, dem
     * Maximum und der Schrittweite. Der Zaehlwert, den dieses Modell
     * repraesentiert, wird mit dem Minimum initialisiert.
     * 
     * @param minimum
     *            Fuer den Zaehlerwert zu verwendendes Minimum
     * @param maximum
     *            Fuer den Zeahlerwert zu verwendendes Maximum
     * @param increment
     *            Fuer den Zeahlerwert zu verwendende Schrittweite
     */
    public PlusMinusModel(final int minimum, final int maximum, final int increment)
    {
        if (maximum < minimum)
        {
            throw new IllegalArgumentException("Das Minimum darf nicht groesser als das Maximum sein!");
        }

        if (increment < 1)
        {
            throw new IllegalArgumentException("Increment darf nicht kleiner als 1 sein.");
        }

        this.count = minimum;
        this.min = minimum;
        this.max = maximum;
        this.step = increment;
        this.count = this.min;
    }

    /**
     * Inkrementiert den aktuellen Zaehlerwert. Beim Inkrementieren ueber das im
     * Konstruktor uebergebene Maximum wird eine Ausnahme ausgeloest.
     */
    public void increment()
    {
        if (this.canIncrement())
        {
            this.count += step;
        }
        else
        {
            throw new CounterModificationNotPossibleException();
        }

        for (IPlusMinusListener item : this.getListener())
        {
            item.plusMinusModelChanged(this);
        }
    }

    /**
     * Dekrementiert den aktuellen Zaehlerwert. Beim Dekrementieren unter das im
     * Konstruktor uebergebene Minimum wird eine Ausnahme ausgeloest.
     */
    public void decrement()
    {
        if (this.canDecrement())
        {
            this.count -= step;
        }
        else
        {
            throw new CounterModificationNotPossibleException();
        }

        for (IPlusMinusListener item : this.getListener())
        {
            item.plusMinusModelChanged(this);
        }
    }

    /**
     * Liefert den aktuellen Zaehlerwert zurueck.
     * 
     * @return int
     */
    public int getCounter()
    {
        return this.count;
    }

    public List<IPlusMinusListener> getListener()
    {
        return this.listener;
    }

    /**
     * Liefert zurueck, ob der Wert noch erhoeht werden kann.
     * 
     * @return boolean
     */
    public boolean canIncrement()
    {
        return (this.step + this.count >= this.max) ? false : true;
    }

    /**
     * Liefert zurueck, ob der Wert noch erniedrigt werden kann.
     * 
     * @return boolean
     */
    public boolean canDecrement()
    {
        return ((this.count - this.step) >= this.min) ? true : false;
    }

    /**
     * Meldet den uebergebenen IPlusMinusListener an diesem Modell an.
     * 
     * @param l
     *            Anzumeldender IPlusMinusListener
     */
    public void addPlusMinusModelListener(final IPlusMinusListener l)
    {
        // l.plusMinusModelChanged(this);
        listener.add(l);
    }

    /**
     * Meldet den uebergebenen IPlusMinusListener an diesem Modell ab.
     * 
     * @param l
     *            Abzumeldender IPlusMinusListener
     */
    public void removePlusMinusModelListener(final IPlusMinusListener l)
    {
        listener.remove(l);
    }
}
