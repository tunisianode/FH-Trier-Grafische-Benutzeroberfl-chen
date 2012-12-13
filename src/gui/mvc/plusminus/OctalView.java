package gui.mvc.plusminus;

import javax.swing.JLabel;

public class OctalView implements IPlusMinusListener
{
    private JLabel label;

    public OctalView(String name, int count)
    {
        label = new JLabel(this.getFormattedString(count));
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
        return String.format("%o", counter) + " (oktal)";
    }
}
