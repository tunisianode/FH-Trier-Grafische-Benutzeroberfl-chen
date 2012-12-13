package gui.mvc.textarea;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitedDocument extends PlainDocument
{
    private static final long serialVersionUID = 1L;

    private int docLength;

    /**
     * Kapazitaet der Zeichen wird als Parameter des Typs int angegeben werden.
     * 
     * @param docLength
     */
    public LimitedDocument(int docLength)
    {
        super();
        this.docLength = docLength;

        if (this.docLength < 0)
        {
            throw new IllegalArgumentException("docLength darf nicht kleiner 0 sein.");
        }
    }

    /**
     * Methode insertString wird ueberschrieben um die Begrenzung einzubauen.
     */
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
    {
        if (this.getLength() + str.length() > this.docLength)
        {
            Toolkit.getDefaultToolkit().beep();
        }
        else
        {
            super.insertString(offs, str, a);
        }
    }
}