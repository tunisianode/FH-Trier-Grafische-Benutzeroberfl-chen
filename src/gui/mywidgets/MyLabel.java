package gui.mywidgets;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyLabel extends JPanel
{
    private String text;
    private Color color;
    private int verticalAlignment;
    private int horizontalAlignment;

    public static final int HORIZONTAL_LEFT = 0;
    public static final int HORIZONTAL_CENTER = 1;
    public static final int HORIZONTAL_RIGHT = 2;
    public static final int VERTICAL_TOP = 3;
    public static final int VERTICAL_CENTER = 4;
    public static final int VERTICAL_BOTTOM = 5;

    public MyLabel()
    {
    }

    MyLabel(String text)
    {
        this.text = text;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(this.getColor());
        g.drawString(this.text, 20, 20);
    }

    public String getText()
    {
        return this.text;
    }

    public void setText(String newText)
    {
        this.text = newText;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void setHorizontalAlignment(int align)
    {
        this.horizontalAlignment = align;
    }

    public int getHorizontalAlignment()
    {
        return this.horizontalAlignment;
    }

    public void setVerticalAlignment(int align)
    {
        this.verticalAlignment = align;
    }

    public int getVerticalAlignment()
    {
        return this.verticalAlignment;
    }
}
