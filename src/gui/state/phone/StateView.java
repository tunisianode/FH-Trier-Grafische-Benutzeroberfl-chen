package gui.state.phone;

import javax.swing.JLabel;

public class StateView extends JLabel implements PhoneListener
{

    private static final long serialVersionUID = 1L;

    public StateView(String name)
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
        setStateText(newState);
    }

    @Override
    public void currentNumberChanged(String newCurrentNumber)
    {
        // TODO Auto-generated method stub

    }
}
