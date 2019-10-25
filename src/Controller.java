public class Controller {



    public static void main(String[] args) {
        Controller myController = new Controller();
        View myview = new View(myController);
        myview.resetGame();
    }
}
