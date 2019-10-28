import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;
    View view;

    public Controller(Model model){
        this.model = model;
        this.view = new View(this);
        view.resetGame();


        //if still only one action req change to "view.resetButton.addActionListener(actionEvent -> view.resetGame);
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

        view.panel_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_1_1.setText("X");
                    model.calltoPlayerTurn(1-1,1-1, "X");
                }
                else {
                    view.panel_1_1.setText("O");
                    model.calltoPlayerTurn(1 - 1, 1 - 1, "O");
                }

                model.setPlayer1Turn();
                view.panel_1_1.setEnabled(false);
            }
        });
        view.panel_1_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_1_2.setText("X");
                    model.calltoPlayerTurn(1-1,2-1, "X");
                }
                else {
                    view.panel_1_2.setText("O");
                    model.calltoPlayerTurn(1 - 1, 2 - 1, "O");
                }

                model.setPlayer1Turn();

                view.panel_1_2.setEnabled(false);
            }
        });
        view.panel_1_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_1_3.setText("X");
                    model.calltoPlayerTurn(1-1,3-1, "X");
                }
                else {
                    view.panel_1_3.setText("O");
                    model.calltoPlayerTurn(1 - 1, 3 - 1, "O");
                }
                model.setPlayer1Turn();


                view.panel_1_3.setEnabled(false);
            }
        });
        view.panel_2_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_2_1.setText("X");
                    model.calltoPlayerTurn(2-1,1-1, "X");
                }
                else {
                    view.panel_2_1.setText("O");
                    model.calltoPlayerTurn(2 - 1, 1 - 1, "O");
                }
                model.setPlayer1Turn();


                view.panel_2_1.setEnabled(false);
            }
        });
        view.panel_2_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_2_2.setText("X");
                    model.calltoPlayerTurn(2-1,2-1, "X");
                }
                else {
                    view.panel_2_2.setText("O");
                    model.calltoPlayerTurn(2 - 1, 2 - 1, "O");
                }
                model.setPlayer1Turn();


                view.panel_2_2.setEnabled(false);
            }
        });
        view.panel_2_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_2_3.setText("X");
                    model.calltoPlayerTurn(2-1,3-1, "X");
                }
                else {
                    view.panel_2_3.setText("O");
                    model.calltoPlayerTurn(2 - 1, 3 - 1, "O");
                }
                model.setPlayer1Turn();

                view.panel_2_3.setEnabled(false);
            }
        });
        view.panel_3_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_3_1.setText("X");
                    model.calltoPlayerTurn(3-1,1-1, "X");
                }
                else {
                    view.panel_3_1.setText("O");
                    model.calltoPlayerTurn(3 - 1, 1 - 1, "O");
                }
                model.setPlayer1Turn();

                view.panel_3_1.setEnabled(false);
            }
        });
        view.panel_3_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_3_2.setText("X");
                    model.calltoPlayerTurn(3-1,2-1, "X");
                }
                else {
                    view.panel_3_2.setText("O");
                    model.calltoPlayerTurn(3 - 1, 2 - 1, "O");
                }
                model.setPlayer1Turn();


                view.panel_3_2.setEnabled(false);
            }
        });
        view.panel_3_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (model.getPlayer1Turn()){
                    view.panel_3_3.setText("X");
                    model.calltoPlayerTurn(3-1,3-1, "X");
                }
                else {
                    view.panel_3_3.setText("O");
                    model.calltoPlayerTurn(3 - 1, 3 - 1, "O");
                }
                model.setPlayer1Turn();


                view.panel_3_3.setEnabled(false);
            }
        });
    }

    public static void main(String[] args) {
        Model model = new Model();
        Controller myController = new Controller(model);
    }
}
