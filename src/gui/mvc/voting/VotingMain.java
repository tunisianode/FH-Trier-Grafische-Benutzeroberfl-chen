package gui.mvc.voting;

import gui.mvc.voting.model.VotingModel;
import gui.mvc.voting.view.IncrementView;
import gui.mvc.voting.view.NewView;
import gui.mvc.voting.view.QuestionView;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class VotingMain extends JFrame
{
    private static final long serialVersionUID = 1L;

    // private VotingModel model;

    public VotingMain()
    {
        this.setLayout(new GridLayout(2, 2));

        String[] candidates =
        { "CDU", "FDP" };
        VotingModel model = new VotingModel(candidates);

        QuestionView questionView = new QuestionView("Welche Partei wollen sie?");
        questionView.setBorder(new TitledBorder("Frage"));

        JPanel newPanel = new JPanel(new GridLayout(1, 2));
        newPanel.setBorder(new TitledBorder("Neue Antwortmöglichkeit hinzufuegen"));
        JLabel extraQuestionLabel = new JLabel();
        extraQuestionLabel.setText("Zusätzliche Antwortmöglichkeiten");
        NewView newView = new NewView();
        newPanel.add(extraQuestionLabel);
        newPanel.add(newView);

        JPanel incrementPanel = new JPanel();
        incrementPanel.setBorder(new TitledBorder("Erhöhen"));

        IncrementView incrementView = new IncrementView(model);
        incrementPanel.add(incrementView);

        add(questionView);
        add(newPanel);
        add(incrementPanel);

        this.setVisible(true);
        this.setSize(200, 200);
    }

    public static void main(String[] args)
    {
        VotingMain vm = new VotingMain();
    }
}
