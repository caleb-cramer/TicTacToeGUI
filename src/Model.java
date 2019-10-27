public class Model {
    //keeps track of who is currently going
    private boolean player1Turn = true;
    Board board = new Board();
    public String getMove(){
        return "X";
    }
    public void setPlayer1Turn(boolean a){
        player1Turn = a;
    }

    public boolean getPlayer1Turn() {
        return player1Turn;
    }


}
