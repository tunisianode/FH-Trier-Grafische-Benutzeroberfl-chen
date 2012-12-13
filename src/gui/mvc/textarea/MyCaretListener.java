package gui.mvc.textarea;

import javax.swing.JLabel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class MyCaretListener implements CaretListener
{
    private JLabel caretLabel;

    public MyCaretListener(JLabel caretLabel)
    {
        this.caretLabel = caretLabel;
    }

    @Override
    public void caretUpdate(CaretEvent e)
    {
        if (e.getMark() != e.getDot())
        {
            this.caretLabel.setText("selection from: " + e.getMark() + " to " + e.getDot());
        }
        else
        {
            this.caretLabel.setText("caret: text position: " + e.getDot());
        }
    }
}
