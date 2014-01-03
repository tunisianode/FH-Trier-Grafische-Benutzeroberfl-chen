package gui.state.phone;

import javax.swing.JLabel;

public class NumberView extends JLabel implements PhoneListener
{
    private static final long serialVersionUID = 1L;

    public NumberView(String name)
    {
        this.setName(name);
    }

    public void setStateText(String text)
    {
        this.setText(text);
    }

    @Override
    public void stateChanged(String newState)
    {
    }

    @Override
    public void currentNumberChanged(String newCurrentNumber)
    {
        this.setText(newCurrentNumber);
    }
}
