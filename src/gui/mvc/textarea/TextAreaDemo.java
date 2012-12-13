package gui.mvc.textarea;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaDemo extends JFrame
{
    private static final long serialVersionUID = 1L;
    private JScrollPane left, right, log;
    private JTextArea leftText, rightText, logText;
    private JButton button;
    private JPanel panelText;
    private JLabel infoLabel;

    public TextAreaDemo(String title)
    {
        this.setTitle(title);
        this.setLayout(new GridLayout(4, 0));

        logText = new JTextArea();
        logText.setName("logArea");
        MyListener ml = new MyListener(logText);

        infoLabel = new JLabel();
        infoLabel.setName("infoLabel");
        infoLabel.setText("infoLabel");

        MyCaretListener mcl = new MyCaretListener(infoLabel);

        log = new JScrollPane(logText);

        LimitedDocument ld = new LimitedDocument(200);
        ld.addDocumentListener(ml);

        leftText = new JTextArea(ld);
        leftText.setName("leftArea");
        leftText.addCaretListener(mcl);
        rightText = new JTextArea(ld);
        rightText.setName("rightArea");
        rightText.addCaretListener(mcl);
        leftText.setEnabled(true);

        left = new JScrollPane(leftText);
        right = new JScrollPane(rightText);

        button = new JButton("Text anhaengen");
        button.setName("appendButton");
        button.addActionListener(new AppendListener(rightText));

        panelText = new JPanel(new GridLayout(1, 2));
        panelText.add(left);
        panelText.add(right);

        this.add(panelText);
        this.add(button);
        this.add(log);
        this.add(infoLabel);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    // public static void main(String[] args)
    // {
    // TextAreaDemo tad = new TextAreaDemo("Stefan");
    // }
}