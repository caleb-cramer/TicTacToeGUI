import javax.swing.*;
import java.awt.*;


/*View of MVC inherits JFramem  */
public class View extends JFrame {
    protected Controller controller;
    protected JButton resetButton; //south
    protected JPanel scoreArea; //north
    protected JPanel gameGrid; //center

    //start of grid of buttons
    protected JButton panel_1_1;
    protected JButton panel_1_2;
    protected JButton panel_1_3;
    protected JButton panel_2_1;
    protected JButton panel_2_2;
    protected JButton panel_2_3;
    protected JButton panel_3_1;
    protected JButton panel_3_2;
    protected JButton panel_3_3;
    //end

    //name, wins and losses of P1
    protected JLabel name1;
    protected JLabel wins1;
    protected JLabel losses1;

    //name, wins and losses of P2
    protected JLabel name2;
    protected JLabel wins2;
    protected JLabel losses2;
    protected JLabel statusLabel;


    //DVC
    public View(Controller c){
        super("Tic Tac Toe");
        this.controller = c;
        setupUI();
        pack();
    }

    //setup the GUI
    protected void setupUI(){
        //general setup
        setVisible(true);
        setPreferredSize(new Dimension(400,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        //South area just has a button
        resetButton = new JButton("Reset Names and Stats");
        contentPanel.add(resetButton, BorderLayout.SOUTH);
        //end south area

        // Center area has a BoxLayout with a label and a grid
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
        //label
        statusLabel = new JLabel("Player 1's Turn!");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(statusLabel);
        //make the grid
        gameGrid = new JPanel();
        gameGrid.setLayout(new GridLayout(3,3));
        //here are all the buttons to fill the grid
        panel_1_1 = new JButton();
        panel_1_1.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_1_1);

        panel_1_2 = new JButton();
        panel_1_2.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_1_2);

        panel_1_3 = new JButton();
        panel_1_3.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_1_3);

        panel_2_1 = new JButton();
        panel_2_1.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_2_1);

        panel_2_2 = new JButton();
        panel_2_2.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_2_2);

        panel_2_3 = new JButton();
        panel_2_3.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_2_3);

        panel_3_1 = new JButton();
        panel_3_1.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_3_1);

        panel_3_2 = new JButton();
        panel_3_2.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_3_2);

        panel_3_3 = new JButton();
        panel_3_3.setFont(new Font("Arial", Font.BOLD, 40));
        gameGrid.add(panel_3_3);

        centerPanel.add(gameGrid);

        contentPanel.add(centerPanel,BorderLayout.CENTER);
        //end center area

        //North area has a grid of labels
        //grid
        scoreArea = new JPanel();
        scoreArea.setLayout(new GridLayout(0,2));

        //text labels
        JLabel nameTitle1 = new JLabel("Name: ");
        JLabel winsTitle1 = new JLabel("Wins: ");
        JLabel lossesTitle1 = new JLabel("Losses: ");
        JLabel nameTitle2 = new JLabel("Name: ");
        JLabel winsTitle2 = new JLabel("Wins: ");
        JLabel lossesTitle2 = new JLabel("Losses: ");

        //value labels
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

    //Function to use when reset button is clicked
    public void resetGame(){
        String player1Name = JOptionPane.showInputDialog("Enter Player 1's name here");

        try {
            if (player1Name.equals("")){
                name1.setText("Player 1");
            }
            else
                name1.setText(player1Name);
        } catch (NullPointerException e) {
            name1.setText("Player 1");
        }
        wins1.setText("0");
        losses1.setText("0");

        String player2Name = JOptionPane.showInputDialog("Enter Player 2's name here");
        try {
            if (player2Name.equals("")){
                name2.setText("Player 2");
            }
            else
                name2.setText(player2Name);
        } catch (NullPointerException e) {
            name2.setText("Player 2");
        }

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

    //function to play new game
    public void again(){
        panel_1_1.setEnabled(true);
        panel_1_2.setEnabled(true);
        panel_1_3.setEnabled(true);
        panel_2_1.setEnabled(true);
        panel_2_2.setEnabled(true);
        panel_2_3.setEnabled(true);
        panel_3_1.setEnabled(true);
        panel_3_2.setEnabled(true);
        panel_3_3.setEnabled(true);

        statusLabel.setText("Player 1's turn");

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

    //function for ending of game
    public void gameOver(){

        String message = statusLabel.getText() + "\nWould you like to play again?";
        String [] options = {"Exit", "Play Again"};
        int result =  JOptionPane.showOptionDialog(null,
                message,
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if(result == 1){
            again();
        }
        else{
            System.exit(0);
        }
    }

    public void winStatus(boolean win){
        if(win){
            statusLabel.setText(name1.getText() + " won!");
        }
        else {
            statusLabel.setText(name2.getText() + " won!");
        }
    }

    //updates win/loss/tie
    public void getStats(int w1, int w2, int l1, int l2){
        wins1.setText(Integer.toString(w1));
        wins2.setText(Integer.toString(w2));
        losses1.setText(Integer.toString(l1));
        losses2.setText(Integer.toString(l2));
    }

    //changes the status label to show turn
    public void switchStatus(boolean turn){
        if(turn){
            statusLabel.setText("Player 1's Turn");
        }
        else {
            statusLabel.setText("Player 2's Turn");
        }
    }
}
