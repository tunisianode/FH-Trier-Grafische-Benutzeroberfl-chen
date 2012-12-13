package gui.mvc.textarea;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyListener implements DocumentListener
{
    private JTextArea log;

    public MyListener(JTextArea log)
    {
        this.log = log;
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {
        this.appendText("CHANGE:", e);
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        this.appendText("INSERT:", e);
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        this.appendText("REMOVE:", e);
    }

    private void appendText(String type, DocumentEvent e)
    {
        this.log.append(type + " " + e.getLength() + " character. Text length = " + e.getDocument().getLength() + ".\n");
    }

}
