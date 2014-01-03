package gui.mywidgets;

import java.awt.Color;

import javax.swing.JFrame;

public class Test extends JFrame
{
    private static final long serialVersionUID = 1L;

    public Test()
    {
        this.setSize(300, 300);

        MyLabel label = new MyLabel("stefan");
        label.setText("ljksdfl");
        label.setColor(Color.blue);

        this.add(label);

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        Test test = new Test();
    }
}
