public class Model {
    //keeps track of who is currently going
    private boolean player1Turn = true;
    Board board = new Board();

    public void setPlayer1Turn(){
        player1Turn = !player1Turn;
    }
    public boolean getPlayer1Turn() {
        return player1Turn;
    }
    public boolean calltoPlayerTurn(int a, int b, String c){
        return board.playerTurn(a,b,c);
    }
    public void resetGame(){
        board = new Board();
        //player1Turn = false;
    }
    public int getWins1(){
        return board.wins1;
    }
    public int getWins2(){
        return board.wins2;
    }
    public int getLosses1(){
        return board.losses1;
    }
    public int getLosses2(){
        return board.losses2;
    }
    public void resetBoard(){
        board.resetBoard();
        player1Turn = false;

    }
}
