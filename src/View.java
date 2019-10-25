import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class View extends JFrame {
    protected Controller controller;
    protected JButton resetButton; //south
    protected JPanel scoreArea; //north
    protected JPanel gameGrid; //center
    private JButton panel_1_1;
    private JButton panel_1_2;
    private JButton panel_1_3;
    private JButton panel_2_1;
    private JButton panel_2_2;
    private JButton panel_2_3;
    private JButton panel_3_1;
    private JButton panel_3_2;
    private JButton panel_3_3;
    private JLabel name1;
    private JLabel wins1;
    private JLabel losses1;
    private JLabel name2;
    private JLabel wins2;
    private JLabel losses2;



    public View(Controller c){
        super("Tic Tac Toe");
        this.controller = c;
        setupUI();
        pack();
    }
    private void setupUI(){
        setVisible(true);
        setPreferredSize(new Dimension(400,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        //South area
        resetButton = new JButton("Reset Names and Stats");
        contentPanel.add(resetButton, BorderLayout.SOUTH);
        //end south area

        //Center area
        gameGrid = new JPanel();
        Border playerUpdate = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),
                "Player 1's Turn",
                TitledBorder.CENTER,
                TitledBorder.ABOVE_TOP,
                new Font("Arial", Font.PLAIN, 25));
        gameGrid.setBorder(playerUpdate);
        gameGrid.setLayout(new GridLayout(3,3));

        panel_1_1 = new JButton("1_1");
        panel_1_1.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_1_1);

        panel_1_2 = new JButton("1_2");
        panel_1_2.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_1_2);

        panel_1_3 = new JButton("1_3");
        panel_1_3.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_1_3);

        panel_2_1 = new JButton("2_1");
        panel_2_1.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_2_1);

        panel_2_2 = new JButton("2_2");
        panel_2_2.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_2_2);

        panel_2_3 = new JButton("2_3");
        panel_2_3.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_2_3);

        panel_3_1 = new JButton("3_1");
        panel_3_1.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_3_1);

        panel_3_2 = new JButton("3_2");
        panel_3_2.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_3_2);

        panel_3_3 = new JButton("3_3");
        panel_3_3.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_3_3);

        contentPanel.add(gameGrid,BorderLayout.CENTER);
        //end center area

        //North area
        scoreArea = new JPanel();
        scoreArea.setLayout(new GridLayout(0,2));

        JLabel nameTitle1 = new JLabel("Name: ");
        JLabel winsTitle1 = new JLabel("Wins: ");
        JLabel lossesTitle1 = new JLabel("Losses: ");
        JLabel nameTitle2 = new JLabel("Name: ");
        JLabel winsTitle2 = new JLabel("Wins: ");
        JLabel lossesTitle2 = new JLabel("Losses: ");

        JPanel player1Score = new JPanel();
        player1Score.setBorder(BorderFactory.createTitledBorder("Player 1(X)"));
        player1Score.setLayout(new GridLayout(3,2));
        player1Score.add(nameTitle1);
        name1 = new JLabel();
        player1Score.add(name1);
        player1Score.add(winsTitle1);
        wins1 = new JLabel();
        player1Score.add(wins1);
        player1Score.add(lossesTitle1);
        losses1 = new JLabel();
        player1Score.add(losses1);

        JPanel player2Score = new JPanel();
        player2Score.setBorder(BorderFactory.createTitledBorder("Player (O)"));
        player2Score.setLayout(new GridLayout(3,2));
        player2Score.add(nameTitle2);
        name2 = new JLabel();
        player2Score.add(name2);
        player2Score.add(winsTitle2);
        wins2 = new JLabel();
        player2Score.add(wins2);
        player2Score.add(lossesTitle2);
        losses2 = new JLabel();
        player2Score.add(losses2);

        scoreArea.add(player1Score);
        scoreArea.add(player2Score);

        contentPanel.add(scoreArea,BorderLayout.NORTH);
        //end north area

        getContentPane().add(contentPanel);
    }

    public void resetGame(){
        String player1Name = JOptionPane.showInputDialog("Enter Player 1's name here");
        if (player1Name.equals("")){
            name1.setText("Player 1");
        }
        else
            name1.setText(player1Name);
        wins1.setText("0");
        losses1.setText("0");

        String player2Name = JOptionPane.showInputDialog("Enter Player 2's name here");
        if (player2Name.equals("")){
            name2.setText("Player 2");
        }
        else
            name2.setText(player1Name);

        wins2.setText("0");
        losses2.setText("0");

        panel_1_1.setText("");
        panel_2_1.setText("");
        panel_3_1.setText("");
        panel_1_2.setText("");
        panel_2_2.setText("");
        panel_3_2.setText("");
        panel_1_3.setText("");
        panel_2_3.setText("");
        panel_3_3.setText("");
    }
}
