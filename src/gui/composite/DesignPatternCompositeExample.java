package gui.composite;

/**
 * Klasse zum Testen (enthält nur main-Methode).
 * 
 * @author Rainer Oechsle
 */
public class DesignPatternCompositeExample
{
    /**
     * Methode zum Erzeugen eines Beispielbaums.
     * 
     * @return Wurzel des Beispielbaums
     */
    public static Container makeExampleTree()
    {
        Container root = new Container("big box", 3);
        PrimitiveElement p1 = new PrimitiveElement("paper", 1, "table of contents");
        root.addChild(p1);
        Container cont1 = new Container("simple box", 2);
        root.addChild(cont1);
        PrimitiveElement p2 = new PrimitiveElement("CD", 1, "Van Morrison");
        cont1.addChild(p2);
        PrimitiveElement p3 = new PrimitiveElement("heavy stuff", 20, "very heavy");
        cont1.addChild(p3);
        Container cont2 = new Container("small box", 1);
        cont1.addChild(cont2);
        PrimitiveElement p4 = new PrimitiveElement("glasses", 1, "to see better");
        cont2.addChild(p4);
        Container cont3 = new Container("yet another box", 2);
        cont2.addChild(cont3);
        PrimitiveElement p5 = new PrimitiveElement("newspaper", 5, "TV");
        cont3.addChild(p5);
        PrimitiveElement p6 = new PrimitiveElement("book", 10, "atlas");
        cont2.addChild(p6);

        PrimitiveElement p7 = new PrimitiveElement("pullover", 4, "for cold days");
        root.addChild(p7);

        return root;
    }
}