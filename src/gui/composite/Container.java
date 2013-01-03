package gui.composite;

import java.util.ArrayList;

/**
 * Klasse zur Repräsentation einer Menge von Elementen (Container).
 * 
 * @author Rainer Oechsle
 */
public class Container extends Component
{
    protected ArrayList<Component> children;

    /**
     * Konstruktor
     * 
     * @param name
     * @param weight
     */
    public Container(String name, int weight)
    {
        super(name, weight);
        children = new ArrayList<Component>();
    }

    /**
     * Fügt ein neues Element als letztes Element zu der Gruppe hinzu. Setzt
     * ausserdem diese Gruppe als Vorgänger des neuen Elements ein.
     * 
     * @param comp
     *            neues Element
     */
    public void addChild(Component comp)
    {
        comp.pred = this;
        children.add(comp);
    }

    /**
     * Entfert ein Element aus der Gruppe.
     * 
     * @param comp
     *            zu entfernendes Element
     */
    public void removeChild(Component comp)
    {
        comp.pred = null;
        children.remove(comp);
    }

    /**
     * Liefert die Anzahl der Elemente der Gruppe zurück.
     * 
     * @return Anzahl der Elemente
     */
    public int getNumberOfChildren()
    {
        return children.size();
    }

    /**
     * Liefert das Element der Gruppe mit dem angegebenen Index zurück.
     * 
     * @param index
     *            Index
     * @return Component
     */
    public Component getChild(int index)
    {
        return children.get(index);
    }

    /**
     * Liefert zu einem gegebenen Element den Index zurück, den dieses Element
     * in der Gruppe besitzt.
     * 
     * @param child
     *            Element der Gruppe
     * @return Index
     */
    public int getIndexOfChild(Component child)
    {
        return children.indexOf(child);
    }

    /**
     * Testet, ob das angegebene Element Mitglied der Gruppe ist.
     * 
     * @param comp
     *            getestetes Element
     * @return true, falls Mitglied, sonst false
     */
    public boolean hasChild(Component comp)
    {
        return children.contains(comp);
    }

    /**
     * Gibt das Objekt aus.
     * 
     * @param indentation
     *            Anzahl der eingerückten Zeichen
     */
    protected void print(int indentation)
    {
        super.print(indentation);
        for (int i = 0; i < getNumberOfChildren(); i++)
        {
            Component child = getChild(i);
            child.print(indentation + 2);
        }
    }

    /**
     * Liefert das Gewicht dieses Objekts und aller darin enthaltenen Objekte.
     * 
     * @return Gewicht
     */
    public int getWeight()
    {
        int result = weight;
        for (int i = 0; i < getNumberOfChildren(); i++)
        {
            Component child = getChild(i);
            result += child.getWeight();
        }
        return result;
    }
}
