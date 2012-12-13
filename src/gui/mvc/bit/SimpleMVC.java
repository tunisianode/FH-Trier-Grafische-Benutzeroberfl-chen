package gui.mvc.bit;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SimpleMVC extends JFrame
{
    private static final long serialVersionUID = 1L;

    public SimpleMVC()
    {
        BitModel bm = new BitModel(8);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1));

        DecimalView dv1 = new DecimalView(bm);
        bm.addModelListener(dv1);
        DecimalView dv2 = new DecimalView(bm);
        bm.addModelListener(dv2);

        BinaryView bv1 = new BinaryView(bm);
        bm.addModelListener(bv1);
        BinaryView bv2 = new BinaryView(bm);
        bm.addModelListener(bv2);

        ControlView cv1 = new ControlView(bm);
        bm.addModelListener(cv1);
        ControlView cv2 = new ControlView(bm);
        bm.addModelListener(cv2);

        this.add(dv1);
        this.add(dv2);
        this.add(bv1);
        this.add(bv2);
        this.add(cv1);
        this.add(cv2);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new SimpleMVC();
    }
}