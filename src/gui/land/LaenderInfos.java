package gui.land;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LaenderInfos extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private JComboBox countrySelector;
    private JCheckBox exactValues;
    private JPanel panel;
    private JLabel[] label;
    private Land[] countries;
    private boolean exactly = false;

    public LaenderInfos(Land[] countries)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 10 JLabels erstellen
        label = new JLabel[10];

        // Panel fuer die Labels.
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        label[0] = new JLabel("Land:");
        label[1] = new JLabel();
        label[1].setName("countryName");
        label[2] = new JLabel("Hauptstadt:");
        label[3] = new JLabel();
        label[3].setName("capital");
        label[4] = new JLabel("Einwohner:");
        label[5] = new JLabel();
        label[5].setName("population");
        label[6] = new JLabel("Flaeche (in qkm):");
        label[7] = new JLabel();
        label[7].setName("area");
        label[8] = new JLabel("Bevoelkerungsdichte (in Personen pro qkm):");
        label[9] = new JLabel();
        label[9].setName("density");

        panel.add(label[0]);
        panel.add(label[1]);
        panel.add(label[2]);
        panel.add(label[3]);
        panel.add(label[4]);
        panel.add(label[5]);
        panel.add(label[6]);
        panel.add(label[7]);
        panel.add(label[8]);
        panel.add(label[9]);

        this.countries = countries;

        countrySelector = new JComboBox();
        countrySelector.setName("countrySelector");
        countrySelector.addActionListener(this);

        for (Land land : countries)
        {
            countrySelector.addItem(land);
        }

        exactValues = new JCheckBox("genau Angaben");
        exactValues.setName("exactValues");
        exactValues.addActionListener(this);

        add(countrySelector);
        add(exactValues);

        setLayout(new GridLayout(0, 1));

        drawLand();

        add(panel);

        setLocation(200, 200);
        setSize(530, 210);
        setVisible(true);
    }

    private void drawLand()
    {
        // Das aktuell ausgewaehlte Land laden.
        Land land = countries[this.countrySelector.getSelectedIndex()];

        label[1].setText(land.getName());
        label[3].setText(land.getHauptstadt());

        if (exactly)
        {
            label[5].setText(Long.toString(land.getEinwohner()));
            label[7].setText(Long.toString(land.getFlaeche()));
        }
        else
        {
            label[5].setText(this.formatieren(land.getEinwohner()));
            label[7].setText(this.formatieren(land.getFlaeche()));
        }

        label[9].setText(new String(Math.round((double) land.getEinwohner() / (double) land.getFlaeche()) + ""));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == exactValues)
        {
            exactly = (exactly) ? false : true;
        }

        this.drawLand();
    }

    private String formatieren(long number)
    {
        String result = "";

        if (number > 999999)
        {
            number = (long) this.returnAfterRoundDigitNum(number, 100000);
            result = new String(number + "");
            result = result.substring(0, result.length() - 6) + " Mill.";
        }
        else if (number > 999)
        {
            if (number > 9999)
            {
                number = (long) this.returnAfterRoundDigitNum(number, 100);
            }
            else
            {
                number = (long) this.returnAfterRoundDigitNum(number, 100);
            }

            // DecimalFormat df = (DecimalFormat)
            // DecimalFormat.getInstance(Locale.GERMAN);
            // DecimalFormat df = new DecimalFormat();
            DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
            df.applyPattern("#,###,##0");
            result = df.format(number);
        }
        else
        {
            result = new String(number + "");
        }

        return result;
    }

    private double returnAfterRoundDigitNum(double paramNumber, int noOfDigit)
    {
        double tempSubtractNum = paramNumber % (10 * noOfDigit);
        double tempResultNum = (paramNumber - tempSubtractNum);
        if (tempSubtractNum >= (5 * noOfDigit))
        {
            tempResultNum = tempResultNum + (10 * noOfDigit);
        }
        return tempResultNum;
    }
}