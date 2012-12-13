package gui.mvc.plusminus;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * GBO-Komponente
 */
public class PlusMinusFrame extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;

    private ButtonView plus, minus;
    private LabelView decimalLabel;
    private OctalView octalLabel;
    private HexView hexadecimalLabel;
    private PlusMinusModel model;

    /**
     * Initialisiert ein neues PlusMinusFrame-Objekt mit dem uebergebenen
     * PlusMinusModel.
     * 
     * @param model
     *            Modell
     */
    public PlusMinusFrame(final PlusMinusModel model)
    {
        this.model = model;

        setLayout(new GridLayout(0, 1));

        plus = new ButtonView("plus");
        plus.getButton().addActionListener(this);
        model.addPlusMinusModelListener(plus);
        add(plus.getButton());

        decimalLabel = new LabelView("decimalLabel", this.model.getCounter());
        this.add(decimalLabel.getLabel());
        model.addPlusMinusModelListener(decimalLabel);

        hexadecimalLabel = new HexView("hexadecimalLabel", this.model.getCounter());
        this.add(hexadecimalLabel.getLabel());
        model.addPlusMinusModelListener(hexadecimalLabel);

        octalLabel = new OctalView("octalLabel", this.model.getCounter());
        this.add(octalLabel.getLabel());
        model.addPlusMinusModelListener(octalLabel);

        minus = new ButtonView("minus");
        minus.getButton().addActionListener(this);
        model.addPlusMinusModelListener(minus);
        add(minus.getButton());

        if (!model.canDecrement())
        {
            minus.getButton().setEnabled(false);
        }

        if (!model.canIncrement())
        {
            plus.getButton().setEnabled(false);
        }

        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.plus.getButton())
        {
            model.increment();
        }
        else
        {
            model.decrement();
        }

        if (!model.canDecrement())
        {
            minus.getButton().setEnabled(false);
        }
        else
        {
            minus.getButton().setEnabled(true);
        }

        if (!model.canIncrement())
        {
            plus.getButton().setEnabled(false);
        }
        else
        {
            plus.getButton().setEnabled(true);
        }

        for (IPlusMinusListener item : model.getListener())
        {
            item.plusMinusModelChanged(model);
        }
    }
}
