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
                        JOptionPane.QUESTION_MESSAGE)==0)
                    view.resetGame();
            }
        });
    }



    public static void main(String[] args) {
        Model model = new Model();
        Controller myController = new Controller(model);
    }
}
