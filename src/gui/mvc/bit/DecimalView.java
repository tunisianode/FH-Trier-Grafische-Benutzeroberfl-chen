package gui.mvc.bit;

import javax.swing.JLabel;

public class DecimalView extends JLabel implements IBitModelListener
{
    private static final long serialVersionUID = 1L;
    private IBitModel bm;

    public DecimalView(IBitModel bm)
    {
        this.bm = bm;
    }

    public void modelChanged()
    {
        int result = 0;

        for (int i = 0; i < bm.getLength(); i++)
        {
            if (bm.get(i))
            {
                result += Math.pow(2, i);
            }
        }

        this.setText(result + "");
    }
}