package gui.pizza;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Pizza extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private JPanel panel, panel2;
    private JButton button;
    private JTextArea text;
    private ButtonGroup buttonGroup;
    private double[] prices;
    private double[] pricesIngredenties;
    private String[] sizes;

    public Pizza(String title, String[] sizes, double[] prices, String[] ingredients, double[] pricesIngredenties)
    {
        super(title);

        this.prices = prices;
        this.sizes = sizes;
        this.pricesIngredenties = pricesIngredenties;

        if (sizes.length != prices.length)
        {
            throw new IllegalArgumentException("Die Laenge von Argument zwei und drei stimmen nicht ueberein.");
        }

        if (ingredients.length != pricesIngredenties.length)
        {
            throw new IllegalArgumentException("Falsche Laengen!");
        }

        ingredients = this.addIngredent("Tomaten", ingredients);
        ingredients = this.addIngredent("K\u00e4se", ingredients);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        int i = 0;
        for (String ingredient : ingredients)
        {
            JCheckBox checkbox = new JCheckBox(ingredient);

            if (i == 0 || i == 1)
            {
                checkbox.setSelected(true);
                checkbox.setEnabled(false);
            }

            checkbox.setActionCommand(ingredient);
            checkbox.setName(ingredient);
            panel.add(checkbox);
            i++;
        }

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 0));
        buttonGroup = new ButtonGroup();

        for (String size : sizes)
        {
            JRadioButton radio = new JRadioButton(size);
            radio.setActionCommand(size);
            radio.setName(size);
            buttonGroup.add(radio);
            panel2.add(radio);
        }

        add(panel);
        add(panel2);

        button = new JButton("Bestellen");
        button.setName("bestellen");
        add(button);
        button.addActionListener(this);

        text = new JTextArea();
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setName("bestelltext");
        add(text);

        setLocationByPlatform(true);
        setSize(300, 400);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        String[] sizes =
        { "klein", "normal", "gross" };
        double[] prices =
        { 1.0d, 2.0d, 3.0d };
        String[] ingredients =
        { "Artischocken", "Paprika", "Ei", "Spinat" };
        double[] pricesIngredenties =
        { 0.50d, 1.0d, 1.0d, 1.0d };

        Pizza pi = new Pizza("Pizza", sizes, prices, ingredients, pricesIngredenties);
    }

    public String[] addIngredent(String name, String[] ingredients)
    {
        String[] tmp = null;

        if (!Arrays.asList(ingredients).contains(name))
        {
            tmp = new String[ingredients.length + 1];
            tmp[0] = name;

            int i = 1;
            for (String ingredent : ingredients)
            {
                tmp[i] = ingredent.toString();
                i++;
            }

            double[] tmpPrices = new double[this.pricesIngredenties.length + 1];
            tmpPrices[0] = 0.0d;

            for (int i1 = 0; i1 < this.pricesIngredenties.length; i1++)
            {
                tmpPrices[i1 + 1] = this.pricesIngredenties[i1];
            }

            this.pricesIngredenties = tmpPrices;
            // ingredients = tmp;
        }

        return tmp;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button)
        {
            String result = "Sie haben eine Pizza der Grš§e \"" + buttonGroup.getSelection().getActionCommand() + "\" mit ";

            double price = 0.0d;
            int size = this.find(this.sizes, buttonGroup.getSelection().getActionCommand());
            price += this.prices[size];

            int i = 0;
            for (Component c : panel.getComponents())
            {
                if (c instanceof JCheckBox)
                {
                    if (((JCheckBox) c).isSelected())
                    {
                        result += ((JCheckBox) c).getActionCommand() + ", ";
                        price += this.pricesIngredenties[i];
                    }
                    i++;
                }
            }

            result += ". Der Preis betrŠgt ";
            result += price;
            result += " Û. Vielen Dank";

            text.setText(result);
        }
    }

    public int find(String[] array, String value)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == value)
            {
                return i;
            }
        }
        return 0;
    }
}
