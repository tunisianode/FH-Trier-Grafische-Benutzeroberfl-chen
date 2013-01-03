package gui.composite;

//import java.util.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * Klasse zum Testen des eigenen Baummodells.
 * 
 * @author Rainer Oechsle
 */
public class DesignPatternCompositeExampleAsTreeModel extends JFrame implements TreeSelectionListener, ActionListener
{
    private static final long serialVersionUID = 1L;
    private JCheckBox typeValue;
    private JTree tree;
    private JButton addContainer, addElement, addButtonContainer, abbortButton, delete;
    private JTextField nameField, weightField, descriptionField, descriptionValue, parentValue, nameValue, weightValue;
    private JDialog dialog;
    private DPCTreeModel model;

    /**
     * Konstruktor
     * 
     * @param title
     * @param treeModel
     */
    public DesignPatternCompositeExampleAsTreeModel(String title, DPCTreeModel treeModel)
    {
        super(title);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setLayout(new GridLayout(0, 2));

        // Button fuer addContainer-Dialog
        nameField = new JTextField();
        weightField = new JTextField();
        descriptionField = new JTextField();

        // Container root = DesignPatternCompositeExample.makeExampleTree();
        // model = new DPCTreeModel(root);
        model = treeModel;
        tree = new JTree(model);
        tree.setName("tree");
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this);

        RightMouseButtonHandler mouseListener = new RightMouseButtonHandler(tree, this);
        tree.addMouseListener(mouseListener);

        JPanel panelLeft = new JPanel(new GridLayout(2, 1));
        JScrollPane pane = new JScrollPane(tree);

        JPanel panelButtons = new JPanel(new GridLayout(1, 3));

        addContainer = new JButton("Schachtel hinzufuegen");
        addContainer.setName("addContainer");
        addContainer.addActionListener(this);

        addElement = new JButton("Gegenstand hinzufuegen");
        addElement.setName("addItem");
        addElement.addActionListener(this);

        delete = new JButton("loeschen");
        delete.setName("delete");
        delete.addActionListener(this);

        panelButtons.add(addContainer);
        panelButtons.add(addElement);
        panelButtons.add(delete);

        panelLeft.add(pane);
        panelLeft.add(panelButtons);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel name = new JLabel();
        name.setText("Name:");

        this.nameValue = new JTextField("name");
        this.nameValue.setName("name");

        JLabel type = new JLabel();
        type.setText("Typ:");

        this.typeValue = new JCheckBox("Schachtel");
        this.typeValue.setName("type");
        this.typeValue.setEnabled(false);

        JLabel weight = new JLabel();
        weight.setText("Gewicht:");

        this.weightValue = new JTextField("weight");
        this.weightValue.setName("weight");

        JLabel description = new JLabel();
        description.setText("Beschreibung:");

        this.descriptionValue = new JTextField();
        this.descriptionValue.setName("descriptionOrChildCount");

        JLabel parent = new JLabel();
        parent.setText("Enthalten in:");

        this.parentValue = new JTextField();
        this.parentValue.setName("parent");

        panel.add(name);
        panel.add(this.nameValue);
        panel.add(type);
        panel.add(this.typeValue);
        panel.add(weight);
        panel.add(this.weightValue);
        panel.add(description);
        panel.add(this.descriptionValue);
        panel.add(parent);
        panel.add(this.parentValue);

        tree.setSelectionRow(0);

        add(panelLeft);
        add(panel);
        setLocation(500, 100);
        setSize(700, 250);
        setVisible(true);
    }

    /**
     * main-Methode.
     * 
     * @param args
     *            Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exc)
        {
        }

        Container root = DesignPatternCompositeExample.makeExampleTree();
        DPCTreeModel model = new DPCTreeModel(root);

        new DesignPatternCompositeExampleAsTreeModel("My Own Tree Model " + "Using The Composite " + "Design Pattern", model);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e)
    {
        if (tree.getLastSelectedPathComponent() instanceof PrimitiveElement)
        {
            PrimitiveElement node = (PrimitiveElement) tree.getLastSelectedPathComponent();
            this.nameValue.setText(node.getName());
            this.typeValue.setSelected(false);
            this.weightValue.setText("" + node.getWeight());
            this.descriptionValue.setText(node.getDescription());
            this.parentValue.setText(node.getPredecessor().getName());
        }

        if (tree.getLastSelectedPathComponent() instanceof Container)
        {
            Container node = (Container) tree.getLastSelectedPathComponent();
            this.nameValue.setText(node.getName());
            this.typeValue.setSelected(true);
            this.weightValue.setText("" + node.getWeight());
            this.descriptionValue.setText("" + node.getNumberOfChildren());

            if (!tree.getModel().getRoot().equals(node))
            {
                this.parentValue.setText(node.getPredecessor().getName());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addContainer || e.getActionCommand().equals("Schachtel hinzufügen"))
        {
            if (tree.getLastSelectedPathComponent() instanceof PrimitiveElement)
            {
                /*
                 * JOptionPane optionPane = new JOptionPane(
                 * "Es kann nur zu Schachteln etwas hinzugefuegt werden.",
                 * JOptionPane.ERROR_MESSAGE); JDialog dialog =
                 * optionPane.createDialog("Fehlermeldung");
                 * dialog.setTitle("Fehlermeldung");
                 * dialog.setAlwaysOnTop(true); dialog.setVisible(true);
                 */

                JOptionPane.showMessageDialog(null, "Es kann nur zu Schachteln etwas hinzugefuegt werden.", "Fehlermeldung",
                        JOptionPane.ERROR_MESSAGE);

            }
            else
            {
                dialog = new JDialog(new JFrame());
                dialog.setName("addContainerDialog");
                dialog.setLayout(new GridLayout(3, 2));

                JLabel name = new JLabel();
                name.setText("Name:");

                nameField.setName("addContainerName");

                JLabel weight = new JLabel();
                weight.setText("Gewicht:");

                weightField.setName("addContainerWeight");

                addButtonContainer = new JButton("Hinzufuegen");
                addButtonContainer.setName("addContainerBtnAdd");
                addButtonContainer.addActionListener(this);
                abbortButton = new JButton("Abbrechen");
                abbortButton.addActionListener(this);

                dialog.add(name);
                dialog.add(nameField);
                dialog.add(weight);
                dialog.add(weightField);
                dialog.add(addButtonContainer);
                dialog.add(abbortButton);

                dialog.setSize(300, 150);
                dialog.setVisible(true);
            }
        }

        if (e.getSource() == addElement || e.getActionCommand().equals("Gegenstand hinzufügen"))
        {
            if (tree.getLastSelectedPathComponent() instanceof PrimitiveElement)
            {
                /*
                 * JOptionPane optionPane = new JOptionPane(
                 * "Es kann nur zu Schachteln etwas hinzugefuegt werden.",
                 * JOptionPane.ERROR_MESSAGE); JDialog dialog =
                 * optionPane.createDialog("Fehlermeldung");
                 * dialog.setTitle("Fehlermeldung");
                 * dialog.setAlwaysOnTop(true); dialog.setVisible(true);
                 */

                JOptionPane.showMessageDialog(null, "Es kann nur zu Schachteln etwas hinzugefuegt werden.", "Fehlermeldung",
                        JOptionPane.ERROR_MESSAGE);

            }
            else
            {

                dialog = new JDialog(new JFrame());
                dialog.setName("addItemDialog");
                dialog.setLayout(new GridLayout(4, 2));

                JLabel name = new JLabel();
                name.setText("Name:");

                nameField.setName("addItemName");

                JLabel weight = new JLabel();
                weight.setText("Gewicht:");

                weightField.setName("addItemWeight");

                JLabel desc = new JLabel();
                desc.setText("Beschreibung:");

                descriptionField.setName("addItemDescription");

                addButtonContainer = new JButton("Hinzufuegen");
                addButtonContainer.setName("addItemBtnAdd");
                addButtonContainer.addActionListener(this);
                abbortButton = new JButton("Abbrechen");
                abbortButton.addActionListener(this);

                dialog.add(name);
                dialog.add(nameField);
                dialog.add(weight);
                dialog.add(weightField);
                dialog.add(desc);
                dialog.add(descriptionField);
                dialog.add(addButtonContainer);
                dialog.add(abbortButton);

                dialog.setSize(300, 150);
                dialog.setVisible(true);
            }

        }

        if (e.getSource() == addButtonContainer || e.getActionCommand().equals("löschen"))
        {

            if (dialog.getName().equals("addContainerDialog"))
            {
                Container node = (Container) tree.getLastSelectedPathComponent();
                Container child = new Container(nameField.getText(), Integer.parseInt(weightField.getText()));
                model.add(node, child);
            }

            // textdok hinzufuegen
            else
            {
                Container node = (Container) tree.getLastSelectedPathComponent();
                PrimitiveElement child = new PrimitiveElement(nameField.getText(), Integer.parseInt(weightField.getText()),
                        descriptionField.getText());

                model.add(node, child);
            }

            dialog.setVisible(false);
            dialog.dispose();
        }

        if (e.getSource() == abbortButton)
        {
            dialog.setVisible(false);
            dialog.dispose();
        }

        if (e.getSource() == delete)
        {
            int returnVal = JOptionPane.showConfirmDialog(null, "Bla Bla Bl", "Loeschen eines Knotens", JOptionPane.OK_CANCEL_OPTION);

            if (returnVal == JOptionPane.OK_OPTION)
            {
                if (tree.getLastSelectedPathComponent() instanceof PrimitiveElement)
                {
                    PrimitiveElement node = (PrimitiveElement) tree.getLastSelectedPathComponent();

                    TreePath path = tree.getSelectionPath();
                    model.remove(node.getPredecessor(), node);
                    tree.setSelectionPath(path.getParentPath());
                }
                else if (tree.getLastSelectedPathComponent() instanceof Container)
                {
                    Container node = (Container) tree.getLastSelectedPathComponent();

                    TreePath path = tree.getSelectionPath();
                    model.remove(node.getPredecessor(), node);
                    tree.setSelectionPath(path.getParentPath());
                }
            }
        }
    }
}