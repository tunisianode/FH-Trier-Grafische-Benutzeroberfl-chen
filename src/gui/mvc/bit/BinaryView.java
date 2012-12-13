package gui.mvc.bit;

import javax.swing.JLabel;

public class BinaryView extends JLabel implements IBitModelListener
{
    private static final long serialVersionUID = 1L;
    private IBitModel bm;

    public BinaryView(IBitModel bm)
    {
        this.bm = bm;
    }

    public void modelChanged()
    {
        String binary = "";

        for (int i = bm.getLength() - 1; i >= 0; i--)
        {
            if (bm.get(i))
            {
                binary += new String("1");
            }
            else
            {
                binary += new String("0");
            }

        }

        this.setText(binary);
    }
}