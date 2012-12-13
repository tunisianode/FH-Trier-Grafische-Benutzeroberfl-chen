package gui.mvc.plusminus;

import javax.swing.JLabel;

public class HexView implements IPlusMinusListener
{
    private JLabel label;

    public HexView(String name, int start)
    {
        label = new JLabel(this.getFormattedString(start));
        label.setName(name);
    }

    public JLabel getLabel()
    {
        return this.label;
    }

    @Override
    public void plusMinusModelChanged(PlusMinusModel model)
    {
        // TODO Auto-generated method stub
        label.setText(this.getFormattedString(model.getCounter()));
    }

    public String getFormattedString(int counter)
    {
        return String.format("%x", counter) + " (hexadezimal)";
    }
}
