import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Controller of MVC is the glue between View and Model
 */
public class Controller {
    Model model;
    View view;

    //reusable code to be used in every single action listener
    public void lineSaver(int row, int col, String pSym){
        if(model.calltoPlayerTurn(row-1,col-1, pSym)){
            view.winStatus(model.getPlayer1Turn());
            view.gameOver();
            model.resetBoard();
        }
        view.getStats(model.getWins1(),
                model.getWins2(),
                model.getLosses1(),
                model.getLosses2());
        if(model.getTotalMoves()==9){
            view.statusLabel.setText("Scratch Game");
            view.gameOver();
            model.resetBoard();
        }
    }

    //Controller constructor
    public Controller(Model model){
        this.model = model;
        this.view = new View(this);
        view.resetGame();

        //action listener for the reset stats button in the south
        view.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "This will end the game and set the win/loss stats to 0. Are you sure?",
                        "Reset names and stats",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE)==0) {
                    view.resetGame();
                    model.resetGame();
                    view.panel_1_1.setEnabled(true);
                    view.panel_1_2.setEnabled(true);
                    view.panel_1_3.setEnabled(true);
                    view.panel_2_1.setEnabled(true);
                    view.panel_2_2.setEnabled(true);
                    view.panel_2_3.setEnabled(true);
                    view.panel_3_1.setEnabled(true);
                    view.panel_3_2.setEnabled(true);
                    view.panel_3_3.setEnabled(true);
                }
            }
        });

        //grid of all buttons
        view.panel_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_1_1.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_1_1.setText("X");
                    lineSaver(1,1, "X");
                }
                else {
                    view.panel_1_1.setText("O");
                    lineSaver(1,1, "O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());
            }
        });
        view.panel_1_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_1_2.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_1_2.setText("X");
                    lineSaver(1,2, "X");
                }
                else {
                    view.panel_1_2.setText("O");
                    lineSaver(1,2, "O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());

            }
        });
        view.panel_1_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_1_3.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_1_3.setText("X");
                    lineSaver(1,3, "X");
                }
                else {
                    view.panel_1_3.setText("O");
                    lineSaver(1,3,"O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());

            }
        });
        view.panel_2_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_2_1.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_2_1.setText("X");
                    lineSaver(2,1,"X");
                }
                else {
                    view.panel_2_1.setText("O");
                    lineSaver(2,1,"O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());

            }
        });
        view.panel_2_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_2_2.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_2_2.setText("X");
                    lineSaver(2,2,"X");
                }
                else {
                    view.panel_2_2.setText("O");
                    lineSaver(2,2,"O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());

            }
        });
        view.panel_2_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_2_3.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_2_3.setText("X");
                    lineSaver(2,3,"X");
                }
                else {
                    view.panel_2_3.setText("O");
                    lineSaver(2,3,"O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());

            }
        });
        view.panel_3_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_3_1.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_3_1.setText("X");
                    lineSaver(3,1,"X");
                }
                else {
                    view.panel_3_1.setText("O");
                    lineSaver(3,1,"O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());

            }
        });
        view.panel_3_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_3_2.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_3_2.setText("X");
                    lineSaver(3,2,"X");
                }
                else {
                    view.panel_3_2.setText("O");
                    lineSaver(3,2,"O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());

            }
        });
        view.panel_3_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.panel_3_3.setEnabled(false);
                if (model.getPlayer1Turn()){
                    view.panel_3_3.setText("X");
                    lineSaver(3,3,"X");
                }
                else {
                    view.panel_3_3.setText("O");
                    lineSaver(3,3,"O");
                }
                model.setPlayer1Turn();
                view.switchStatus(model.getPlayer1Turn());

            }
        });
    }

    //main
    public static void main(String[] args) {
        Model model = new Model();
        Controller myController = new Controller(model);
    }
}
