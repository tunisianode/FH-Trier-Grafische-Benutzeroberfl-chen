package gui.mvc.plusminus;

import javax.swing.JLabel;

public class LabelView implements IPlusMinusListener
{
    private JLabel label;

    public LabelView(String name, int count)
    {
        label = new JLabel(count + " (dezimal)");
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
        label.setText(new String(model.getCounter() + " (dezimal)"));
    }
}