package gui.mvc.plusminus;

import javax.swing.JButton;

public class ButtonView implements IPlusMinusListener
{
    private JButton button;

    public ButtonView(String name)
    {
        this.button = new JButton(name);
        this.button.setName(name);
    }

    public JButton getButton()
    {
        return button;
    }

    @Override
    public void plusMinusModelChanged(PlusMinusModel model)
    {
        System.out.println("++");
    }
}
