public class Model {
    //keeps track of who is currently going
    private boolean player1Turn = true;
    Board board = new Board();
    public String getMove(){
        return "X";
    }
    public void setPlayer1Turn(){
        player1Turn = !player1Turn;
    }

    public boolean getPlayer1Turn() {
        return player1Turn;
    }

    public void calltoPlayerTurn(int a, int b, String c){
        board.playerTurn(a,b,c);
    }

    public void resetGame(){
        board = new Board();
    }



}
